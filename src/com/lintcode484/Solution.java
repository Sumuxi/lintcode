package com.lintcode484;

/**484. 交换数组两个元素
 * 
 * @author sumuxi
 *
 */
public class Solution {
	
    /**
     * @param A: An integer array
     * @param index1: the first index
     * @param index2: the second index
     * @return: nothing
     */
    public void swapIntegers(int[] A, int index1, int index2) {
        int t = A[index1];
        A[index1] = A[index2];
        A[index2] = t;
    }

}