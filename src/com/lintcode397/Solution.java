package com.lintcode397;

/**397. 最长上升连续子序列
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param A: An array of Integer
     * @return: an integer
     */
	public int longestIncreasingContinuousSubsequence(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; ) {
			int k=i-1;
			while (k>=0&&A[k]==A[i]) {
				k--;
			}
			k++;
        	int j=i+1;
			while (j<A.length&&A[j]==A[i]) {
				j++;
			}
			if(j==A.length){
				if(j-k>max)
					max=j-k;
				break;
			}
			if(A[j]>A[i]){//上升
				while (j<A.length&&A[j]>=A[j-1]) {
					j++;
				}
			}else {//下降
				while (j<A.length&&A[j]<=A[j-1]) {
					j++;
				}
			}
			if(j-k>max)
				max=j-k;
			if(j==A.length)
				break;
			i = j-1;
		}
        return max;
    }
	
}
