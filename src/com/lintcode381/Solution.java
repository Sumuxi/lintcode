package com.lintcode381;

/**381. 螺旋矩阵 II
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param n: An integer
     * @return: a square matrix
     */
    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
    	int i=0, j=0;
        int s=n-1;
        int t=n-1;
        int p=1;
        while(i<=s&&j<=t){
        	int k=j;
            while (k<=t) {
            	matrix[i][k++] = p++;
    		}
            k=++i;
            while (k<=s) {
            	matrix[k++][t] = p++;
    		}
            k=--t;
            while (i<=s&&k>=j) {//注意i<=m
            	matrix[s][k--] = p++;
    		}
            k=--s;
            while (j<=t&&k>=i) {//注意j<=n
            	matrix[k--][j] = p++;
    		}
            j++;
        }
        return matrix;
    }
	
}
