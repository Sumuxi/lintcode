package com.lintcode077;

/**77. 最长公共子序列
 * 
 * @author sumuxi
 *
 */
public class Solution {

	/**动态规划，内存优化一下
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
	public int longestCommonSubsequence(String A, String B) {
        int n = B.length()+1;
        int[] c1 = new int[n];
        int[] c2 = new int[n];
        for (int i=0; i<A.length(); i++) {
			for (int j=1; j<n; j++) {
				if(A.charAt(i)==B.charAt(j-1))
					c2[j] = c1[j-1]+1;
				else if(c1[j]>=c2[j-1])
					c2[j] = c1[j];
				else 
					c2[j] = c2[j-1];
			}
			int[] temp = c1;
			c1 = c2;
			c2 = temp;
		}
        int max=0;
        for (int k=1; k<c1.length; k++) {//因为每次都会调换c1和c2，这里应该遍历c1
			if(c1[k]>max){
				max=c1[k];
			}
		}
        return max;
    }

    
    /**经典动态规划问题, 最长公共子序列, LCS问题
     */
    public String longestCommonSubsequence1(String A, String B) {
    	int m = A.length()+1;
        int n = B.length()+1;
        int c[][] = new int[m][n];
        int i=1,j=1;
        for (i=1; i<m; i++) {
			for (j=1; j<n; j++) {
				if(A.charAt(i-1)==B.charAt(j-1))
					c[i][j] = c[i-1][j-1]+1;
				else if(c[i-1][j]>=c[i][j-1])
					c[i][j] = c[i-1][j];
				else 
					c[i][j] = c[i][j-1];
			}
		}
        i=m-1;
        j=n-1;
        StringBuilder sb = new StringBuilder();
        while(i>0&&j>0){
        	if(A.charAt(i-1)==B.charAt(j-1)){
        		sb.append(A.charAt(--i));
        		j--;
        	}else if(c[i][j]==c[i-1][j]){//判断c[i-1][j]>=c[i][j-1]也可
        		i--;
        	}else {
				j--;
			}
        }
        return sb.toString();
    }
}
