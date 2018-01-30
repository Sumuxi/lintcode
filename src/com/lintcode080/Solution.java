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
	
	/** WA 答案不对
     * @param : A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median1(int[] nums) {
        // write your code here
        if(nums.length==1){
            return nums[0];
        }
        int mid = (nums.length-1)/2;
        for(int i=0,j=nums.length-1; i<j; i++,j--){
            if(nums[i]>nums[mid]&&nums[j]>nums[mid]){
                if(nums[i]<nums[j]){
                    int temp = nums[mid];
                    nums[mid] = nums[i];
                    nums[i] = temp;
                }else{
                    int temp = nums[mid];
                    nums[mid] = nums[j];
                    nums[j] = temp;
                }
            }else if(nums[i]<nums[mid]&&nums[j]<nums[mid]){
                if(nums[i]>nums[j]){
                    int temp = nums[mid];
                    nums[mid] = nums[i];
                    nums[i] = temp;
                }else{
                    int temp = nums[mid];
                    nums[mid] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[mid];
    }

}
