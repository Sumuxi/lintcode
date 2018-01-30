package com.lintcode015;

import java.util.ArrayList;
import java.util.List;

/**15. 全排列,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.permute(new int[]{1,2,3});
		for (int i = 0; i < s.rlist.size(); i++) {
			System.out.println(s.rlist.get(i));
		}
	}
	
	/**这个方法比solution2的方法快...
	 * list 使用 ArrayList<Integer>
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
	List<List<Integer>> rlist = new ArrayList<List<Integer>>();
	public List<List<Integer>> permute(int[] nums) {
        // write your code here
    	byte[] flags = new byte[nums.length];
    	for (int i = 0; i < nums.length; i++) {
			flags[i] = 1;
		}
    	generate(new ArrayList<Integer>(), nums.length, nums, flags);
    	return rlist;
    }

	private void generate(ArrayList<Integer> list, int n, int[] nums, byte[] flags) {
		if(list.size()==n){
			List<Integer> l = new ArrayList<Integer>();
			for (int i = 0; i < list.size(); i++) {
				l.add(list.get(i).intValue());
			}
			rlist.add(l);
		}else {
			for (int i = 0; i < flags.length; i++) {
				if (flags[i]==(byte)1) {
					list.add(nums[i]);
					flags[i] = (byte)-1;
				}else {
					continue;
				}
				
				generate(list, n, nums, flags);
				list.remove(list.size()-1);
				flags[i] = (byte)1;
			}
		}
	}
	
}
