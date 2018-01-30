package com.lintcode015;

import java.util.ArrayList;
import java.util.List;

/**15. 全排列,AC
 * @author sumuxi
 *
 */
public class Solution3 {
	
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		s.permute(new int[]{1,2,3});
		for (int i = 0; i < s.rlist.size(); i++) {
			System.out.println(s.rlist.get(i));
		}
	}
	
	/**换位法
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
	List<List<Integer>> rlist = new ArrayList<List<Integer>>();
	public List<List<Integer>> permute(int[] nums) {
        // write your code here
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		rlist.add(list);
		
		int i=0;
		while (i<nums.length-1) {
			int n = rlist.size();
			for (int s = 0; s < n; s++) {
				List<Integer> newList = rlist.get(s);
				for (int j = i+1; j < newList.size(); j++) {
					if ( !newList.get(i).equals(newList.get(j)) ) {
						List<Integer> l = new ArrayList<Integer>();
						for (int k = 0; k < newList.size(); k++) {
							l.add(newList.get(k).intValue());
						}
						Integer in = l.get(i);
						l.set(i, newList.get(j));
						l.set(j, in);
						rlist.add(l);
					}
				}
			}
			i++;
		}
    	
    	return rlist;
    }
	
}
