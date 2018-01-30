package com.lintcode014;

/**14. 二分查找 ,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(binarySearch(new int[]{1, 2, 3, 3, 4, 5, 10}, 3));
	}
	
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearch(int[] nums, int target) {
    	if(nums.length==0){
    		return -1;
    	}
    	
    	int start = 0;
    	int end = nums.length-1;
    	int half;
    	while (start<=end) {
    		half = (start+end)/2;
    		if (target<nums[half]) {//左
    			end = half-1;
    		}else if (target>nums[half]) {//右
    			start = half+1;
    		}else {//target==nums[half]
    			//有可能有重复元素，保证返回的索引指向重复元素的第一个
    			while(--half>-1&&target==nums[half]);
    			return half+1;
    		}
		}
    	return -1;
    }

}
