package com.lintcode139;

import java.util.List;

/**139. 最接近零的子数组和
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
    
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
    	int max=Integer.MAX_VALUE;
    	int sum;
        int i = 0;
        int j = 0;
        int[] result = new int[2];
    	while(i < nums.length) {
			j=i;
			sum=0;
    		while(j < nums.length) {
				sum+=nums[j];
				if(Math.abs(sum)<max){
					result[0] = i;
					result[1] = j;
				}
				j++;
			}
    		i++;
		}
    	return result;
    }
}
