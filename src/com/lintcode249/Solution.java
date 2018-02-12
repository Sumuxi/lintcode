package com.lintcode249;

import java.util.List;

/**249. 统计前面比自己小的数的个数
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**简单循环方法,TLE
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> countOfSmallerNumberII1(int[] arr) {
    	List<Integer> result = new java.util.ArrayList<Integer>();
    	if(arr.length==0)
    		return result;
    	result.add(0);
    	int count;
    	for (int i = 1; i < arr.length; i++) {
			count=0;
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i]){
					count++;
				}
			}
			result.add(count);
		}
    	return result;
    }
	
    //循环方法，进行一定的优化
    public List<Integer> countOfSmallerNumberII(int[] arr) {
    	List<Integer> result = new java.util.ArrayList<Integer>();
    	if(arr.length==0)
    		return result;
    	result.add(0);
    	for (int i = 1; i < arr.length; i++) {
    		int j=i-1;
			while(j>=0) {
				if(arr[i]>arr[j]){
					result.add(result.get(j).intValue()+1);
					break;
				}else if(arr[i]==arr[j]){
					result.add(result.get(j).intValue());
					break;
				}
				j--;
			}
			if(j<0){
				result.add(0);
			}
		}
    	return result;
    }
    
}
