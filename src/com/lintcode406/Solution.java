package com.lintcode406;

/**406. 和大于S的最小子数组
 * 挑战：如果你已经完成了O(n)时间复杂度的编程，请再试试 O(n log n)时间复杂度
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
	public int minimumSize(int[] nums, int s) {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	int j=i;
			int sum = 0;
			while (j<nums.length) {
				sum+=nums[j];
				if(sum>=s){
					if(j-i+1<min)
						min = j-i+1;
					break;
				}
				j++;
			}
			if(j==nums.length&&sum<s)
				break;
		}
		if(min==Integer.MAX_VALUE)
			return -1;
        return min;
    }
	
}
