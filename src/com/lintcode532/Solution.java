package com.lintcode532;

/**532. 逆序对
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param A: an array
     * @return: total of reverse pairs
     */
    public long reversePairs(int[] arr) {
    	long count=0;
        for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j])
					count++;
			}
		}
        return count;
    }
    
}
