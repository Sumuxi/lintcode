package com.lintcode159;

/**159. 寻找旋转排序数组中的最小值
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**二分查找的思想
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin1(int[] nums) {
    	int start = 0;
        int end = nums.length - 1;
        if(nums[start]<=nums[end])
        	return nums[start];
        int mid = 0;
        while (start<=end) {
			mid = (start+end)/2;
			if(nums[mid]>=nums[0]){//在前半段
				start = mid+1;
			}else {//在后半段
				end = mid-1;
			}
		}
        return nums[start];
    }
    
    public int findMin(int[] nums) {
    	int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start<=end) {
			mid = (start+end)/2;
			if(nums[mid]<=nums[nums.length-1]){//在后半段
				end = mid-1;
			}else {//在前半段
				start = mid+1;
			}
		}
        return nums[start];
    }
    
}
