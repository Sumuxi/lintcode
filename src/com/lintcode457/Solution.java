package com.lintcode457;

/**457. 经典二分查找问题
 * 挑战：O(logn) 的时间
 * @author sumuxi
 *
 */
public class Solution {
    
	/**二分法
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid;
        while (start<=end) {
			mid = (start+end)>>>1;
			if(target<nums[mid]){
				end = mid-1;
			}else if (target>nums[mid]) {
				start = mid+1;
			}else {
				return mid;
			}
		}
        return -1;
    }
    
}
