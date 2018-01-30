package com.lintcode015;

import java.util.ArrayList;
import java.util.List;

/**15. 全排列,AC
 * @author sumuxi
 *
 */
public class Solution2 {
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		s.permute(new int[]{1,2,3});
		for (int i = 0; i < s.rlist.size(); i++) {
			System.out.println(s.rlist.get(i));
		}
	}
	
	/**这个方法居然比solution的方法要慢,？？？
	 * 很可能是自动装箱的问题
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
    	generate(new int[nums.length], 0, nums, flags);
    	return rlist;
    }

	private void generate(int[] list, int n, int[] nums, byte[] flags) {
		if(n == nums.length){
			List<Integer> l = new ArrayList<Integer>();
			for (int i = 0; i < list.length; i++) {
				l.add(list[i]);//自动装箱
			}
			rlist.add(l);
		}else {
			for (int i = 0; i < flags.length; i++) {
				if (flags[i]==(byte)1) {
					list[n] = nums[i];
					flags[i] = (byte)-1;
				}else {
					continue;
				}
				generate(list, n+1, nums, flags);
				flags[i] = (byte)1;
			}
		}
	}
	
}
