package com.lintcode018;

import java.util.List;

/**
 * 18. 带重复元素的子集
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

		Solution s = new Solution();
		s.subsetsWithDup(new int[]{1,2,2});
		for (int i = 0; i < s.rlist.size(); i++) {
			System.out.println(s.rlist.get(i));
		}
	}

	/**回溯与递归，加去重
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
	List<List<Integer>> rlist = new java.util.ArrayList<List<Integer>>(); 
	public List<List<Integer>> subsetsWithDup(int[] nums) {
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
			add(rlist, copy(list));
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
	private void add(List<List<Integer>> rlist2, List<Integer> list) {
		if (!contain(rlist2, list)) {
			rlist2.add(list);
		}
	}
	
	private boolean contain(List<List<Integer>> rlist2, List<Integer> list) {
		for (int i = 0; i < rlist2.size(); i++) {
			if (isEqual(rlist2.get(i), list)) {
				return true;
			}
		}
		return false;
	}
	private boolean isEqual(List<Integer> list1, List<Integer> list2) {
		if (list1.size()!=list2.size()){
			return false;
		}
		//list1.size()==list2.size()
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).intValue()!=list2.get(i).intValue()) {
				return false;
			}
		}
		return true;
	}
	private List<Integer> copy(java.util.ArrayList<Integer> list) {//list的深拷贝方法
		java.util.ArrayList<Integer> t = new java.util.ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			t.add(list.get(i).intValue());
		}
		return t;
	}
}
