package com.lintcode189;

/**189. 丢失的第一个正整数
 * 挑战：只允许时间复杂度O(n)的算法，并且只能使用常数级别的空间。
 * @author sumuxi
 *
 */
public class Solution {
    
	/**利用桶排序的思想
     * @param A: An array of integers
     * @return: An integer
     */
	public int firstMissingPositive(int[] A) {
    	for (int i = 0; i < A.length; i++) {
    		while (A[i]>0&&A[i]<A.length&&A[A[i]-1]!=A[i]){
				int t = A[A[i]-1];
				A[A[i]-1] = A[i];
				A[i] = t;
			}
		}
		int i = 0;
    	while (i<A.length) {
    		if(A[i]!=++i){
				return i;
			}
		}
    	return A.length+1;
    }
	
}
