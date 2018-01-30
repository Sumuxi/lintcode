package com.lintcode016;

import java.util.ArrayList;
import java.util.List;

/**16. 带重复元素的排列
 * @author sumuxi
 *
 */
public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		s.permuteUnique(new int[]{1,1,3,3});
		for (int i = 0; i < s.rlist.size(); i++) {
			System.out.println(s.rlist.get(i));
		}
	}
	
	/**两个不相同元素交换即得到一种新排列,临位对换法,不正确,但是思路很好
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
	List<List<Integer>> rlist = new ArrayList<List<Integer>>();
	public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		rlist.add(list);
		
		for (int i = 0; i < list.size()-1; i++) {
			for (int j = i+1; j < list.size(); j++) {
				if ( !list.get(i).equals(list.get(j)) ) {
					List<Integer> l = new ArrayList<Integer>();
					for (int k = 0; k < list.size(); k++) {
						l.add(list.get(k).intValue());
					}
					
					Integer in = l.get(i);
					l.set(i, list.get(j));
					l.set(j, in);
					rlist.add(l);
				}
			}
		}
		
    	return rlist;
    }

}
