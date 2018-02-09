package com.lintcode402;

import java.util.List;

/**402. 连续子数组求和
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        List<Integer> result = new java.util.ArrayList<Integer>(2);
        result.add(0);
        result.add(0);
        int max1=Integer.MIN_VALUE;
        //数组中只有负数或者0,只需要返回最大的数所在的区间即可
        int i=0;
        while (i<A.length&&A[i]<=0) {
        	if(A[i]>max1){
        		max1=A[i];
        		result.set(0, i);
        		result.set(1, i);
        	}
        	i++;
		}
        if(i==A.length)
        	return result;
        
        //此时A[i]>0
        int sum1 = 0;
        int sum2 = 0;
        for (int j = i; j < A.length; ) {
			//计算连续的非负数和及其区间
        	while (j<A.length&&A[j]>=0) {
				sum1+=A[j];
				j++;
			}
			if(sum1>max1){
				max1=sum1;
				result.set(0, i);
				result.set(1, j-1);
			}
			//计算连续的负数和
			while (j<A.length&&A[j]<0) {
				sum2+=A[j];
				j++;
			}
			//sum1+sum2>=0时，i不要动，否则，i=j
			if(sum1+sum2>=0){
				sum1+=sum2;
				sum2=0;
			}else {
				sum1=0;
				sum2=0;
				i=j;
			}
		}
        return result;
    }
	
}
