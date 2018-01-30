package com.lintcode041;

/**
 * 41. 最大子数组,AC
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

		System.out.println(maxSubArray(new int[]{-2,-3,-1}));
	}

	/**
	 * @param nums:A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	public static int maxSubArray(int[] nums) {
		// write your code here
		int max = 0;
		int pSum = 0;
		int nSum = Integer.MIN_VALUE;//如果数组仅含负数，则最大负数即为所求
		boolean flag = true;//如果数组仅包含负数，则根据标志，输出最大负数，否则，输出最大子数组的和
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]<0) {
				if (nums[i]>nSum) {
					nSum = nums[i];
				}
			}else {
				flag = false;
			}
			
			pSum += nums[i];
			if (pSum<=0) {
				pSum=0;
			}else {
				if (pSum>max) {
					max=pSum;
				}
			}
		}

		return flag?nSum:max;
	}
}
