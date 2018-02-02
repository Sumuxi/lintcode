package com.lintcode160;

/**160. 寻找旋转排序数组中的最小值 II
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**二分查找的思想
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
    	int start = 0;
        int end = nums.length - 1;
        while(end>0&&nums[start]==nums[end]){
        	end--;
        }
        int tail = end;
        int mid;
        while (start<=end) {
			mid = (start+end)/2;
			if(nums[mid]<=nums[tail]){//在后半段
				end = mid-1;
			}else {//在前半段
				start = mid+1;
			}
		}
        return nums[start];
    }
    
}
