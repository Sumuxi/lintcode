package com.lintcode016;

import java.util.ArrayList;
import java.util.List;

/**16. 带重复元素的排列
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.permuteUnique(new int[]{1,2,2});
		for (int i = 0; i < s.rlist.size(); i++) {
			System.out.println(s.rlist.get(i));
		}
	}
	
	/**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
	List<List<Integer>> rlist = new ArrayList<List<Integer>>();
	public List<List<Integer>> permuteUnique(int[] nums) {
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
			if (contain(rlist, list)) {
				return;
			}
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

	private boolean contain(List<List<Integer>> rlist, ArrayList<Integer> list) {
		for (int i = 0; i < rlist.size(); i++) {//两个表的size是一样的
			if (isEqual(rlist.get(i), list)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isEqual(List<Integer> list1, List<Integer> list2) {
		for (int i = 0; i < list1.size(); i++) {//两个表的size是一样的
			if (list1.get(i).intValue() != list2.get(i).intValue()) {
				return false;
			}
		}
		return true;
	}

}
