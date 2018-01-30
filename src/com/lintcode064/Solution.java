package com.lintcode064;

/**64. 合并排序数组
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}
	
	/**归并排序的思想
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    	int k = m+n-1;
    	int i = m-1;
    	int j = n-1;
    	while(i>=0&&j>=0){
    		if(A[i]>=B[j]){
    			A[k--] = A[i--];
    		}else {
    			A[k--] = B[j--];
			}
    	}
    	while(i>=0){
    		A[k--] = A[i--];
    	}
    	while(j>=0){
    		A[k--] = B[j--];
    	}
    }
    
}
