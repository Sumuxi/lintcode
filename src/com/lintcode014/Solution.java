package com.lintcode014;

/**14. 二分查找 ,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	/*
	 * 思路：二分查找
	 */
	
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
    	if(nums.length==0){
    		return -1;
    	}
    	
    	int start = 0;
    	int end = nums.length-1;
    	int half;
    	while (start<=end) {
    		half = (start+end)>>>1;
    		//这里也有一种防止溢出的写法：half = start + (end-start)>>>1;
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

    public int binarySearch1(int[] nums, int target) 
    {
        int x=0;
        int y=nums.length;
        int m;
        while(x<y)
        {
            m=x+(y-x)/2;
            if(nums[m]<target)
                x=m+1;
            else
                y=m;
        }
        if(x>=nums.length||nums[x]!=target)
            return -1;
        else
            return x;
    }
    
}
