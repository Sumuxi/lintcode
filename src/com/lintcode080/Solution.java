package com.lintcode080;

/**
 * 80. 中位数
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

	}
	
	//挑战：时间复杂度为O(n)
	
	/** 先快排，再取 nums[(nums.length-1)/2]
     * @param : A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        // write your code here
        if(nums.length==1){
            return nums[0];
        }
        java.util.Arrays.sort(nums);
        return nums[(nums.length-1)/2];
    }
	
    /** 快排划分
     * @param : A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median1(int[] nums) {
    	assert nums.length>0;
    	if(nums.length==1){
            return nums[0];
        }
    	int left = 0;
		int right = nums.length-1;
		int i = partition(nums, left, right);
		int k=right>>>1;
		while (i!=k) {
			if(i>k){
				right = i-1;//减小右边界
				i = partition(nums, left, right);
			}else {//i<k
				left = i+1;//增大左边界
				i = partition(nums, left, right);
			}
		}
		return nums[k];
    }

	private int partition(int[] nums, int left, int right) {
		int pivot = nums[right];
		int i = left;
		//把比枢纽小的值全放在左边
		for (int j=left; j<right; j++) {
			if(nums[j]<=pivot){
				int t = nums[i];
				nums[i++] = nums[j];
				nums[j] = t;
			}
		}
		nums[right] = nums[i];
		nums[i] = pivot;
		return i;
	}
    
}
