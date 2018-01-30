package com.lintcode017;

import java.util.List;

/**
 * 17. 子集
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

		Solution s = new Solution();
		s.subsets(new int[]{1,2,3});
		for (int i = 0; i < s.rlist.size(); i++) {
			System.out.println(s.rlist.get(i));
		}
	}

	/**回溯与递归
     * @param nums: A set of numbers
     * @return: A list of lists
     */
	List<List<Integer>> rlist = new java.util.ArrayList<List<Integer>>(); 
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
    	java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
    	rlist.add(copy(list));
    	if (nums.length==0) {
			return rlist;
		}
    	
    	java.util.Arrays.sort(nums);

    	NewSub(list, 0, nums);
    	
    	
    	return rlist;
    }
	private void NewSub(java.util.ArrayList<Integer> list, int i, int[] values) {
		while(true){
			list.add(values[i]);
			rlist.add(copy(list));
			i++;
			if (i<values.length) {
				NewSub(list, i, values);
			}else {
				list.remove(list.size()-1);
				break;
			}
			list.remove(list.size()-1);
		}
	}
	private List<Integer> copy(java.util.ArrayList<Integer> list) {//list的深拷贝方法
		java.util.ArrayList<Integer> t = new java.util.ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			t.add(list.get(i).intValue());
		}
		return t;
	}
}
