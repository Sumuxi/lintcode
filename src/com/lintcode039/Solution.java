package com.lintcode039;

import java.util.List;

/**36. 翻转链表 II
 * 挑战：使用O(1)的额外空间和O(n)时间复杂度
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution());
	}

	private int meiyoushixian;
	
	/**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
    	if(nums.size()<2) return;//0,1
    	
    	int index = 0;
    	while (index<nums.size()-1&&nums.get(index)<=nums.get(index+1)) {
			index++;
		}
    	if(index==nums.size()) return;//已经排序，不需要旋转
    	
    	List<Integer> list = new java.util.ArrayList<Integer>();
    	if(index<(nums.size()-1)/2){//把前面的存起来
    		for (int i = 0; i <= index; i++) {//把前面的临时存起来
				list.add(nums.get(i));
			}
    		for (int i=0,j=index+1; j<nums.size(); i++,j++) {//把后面的移到前面来
				nums.set(i, nums.get(j));
			}
    		for (int i=nums.size()-1,j=list.size()-1; j>=0; i--,j--) {//把存起来的放到后面
				nums.set(i, list.get(j));
			}
    	}else {//把后面的存起来
    		for (int i=index+1; i<nums.size(); i++) {
				list.add(nums.get(i));
			}
    		for (int i=nums.size()-1,j=index; j>=0; i--,j--) {//把前面的移到后面
				nums.set(i, nums.get(j));
			}
    		for (int i=0,j=0; j<list.size(); i++,j++) {//把存起来的放到前面
				nums.set(i, list.get(j));
			}
		}
    }
	
}
