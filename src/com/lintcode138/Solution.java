package com.lintcode138;

import java.util.List;

/**138. 子数组之和
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        int sum;
        int i = 0;
        int j = 0;
    	outter:while(i < nums.length) {
			j=i;
			sum=0;
    		while(j < nums.length) {
				sum+=nums[j];
				if(sum==0){
					break outter;
				}
				j++;
			}
    		i++;
		}
        List<Integer> list = new java.util.ArrayList<Integer>();
        list.add(i);
        list.add(j);
        return list;
    }
    
}
