package com.lintcode050;

import java.util.List;

/**50. 数组剔除元素后的乘积
 * 
 * @author sumuxi
 *
 */
public class Solution {

	/**用两个数组来保存中间结果
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
    	if(nums==null||nums.size()==0){
    		return null;
    	}
    	
    	long[] arr1 = new long[nums.size()];
    	arr1[0] = 1;
    	for (int i = 0; i < nums.size()-1; i++) {
    		arr1[i+1] = arr1[i]*nums.get(i);
		}
    	long[] arr2 = new long[nums.size()];
    	arr2[arr2.length-1] = 1;
    	for (int i = nums.size()-1; i>0; i--) {
    		arr2[i-1] = arr2[i]*nums.get(i);
		}
    	
    	List<Long> result = new java.util.ArrayList<Long>();
    	for (int i = 0; i < nums.size(); i++) {
			result.add(arr1[i]*arr2[i]);
		}
    	
    	return result;//如果nums.size()==1,返回 [1]
    }
    
    public List<Long> productExcludeItself1(List<Integer> nums) {
    	if(nums==null||nums.size()==0){
    		return null;
    	}
    	
    	List<Long> result = new java.util.ArrayList<Long>(nums.size());
    	result.add(1l);
    	for (int i = 0; i < nums.size()-1; i++) {
    		result.add(nums.get(i)*result.get(result.size()-1));
		}
    	
    	long t = 1;
    	for (int i=nums.size()-1; i>0; i--) {
			result.set(i, t*result.get(i));
			t = t*nums.get(i);
		}
    	result.set(0, t*result.get(0));
    	
    	return result;
    }
	
}
