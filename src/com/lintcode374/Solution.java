package com.lintcode374;

import java.util.List;

/**374. 螺旋矩阵
 * 挑战：在原数组中完成，不使用额外空间。
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new java.util.ArrayList<Integer>();
        int i=0, j=0;
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        List<Integer> result 
        = new java.util.ArrayList<Integer>(matrix.length*matrix[0].length);
        
        while(i<=m&&j<=n){
        	int k=j;
            while (k<=n) {
    			result.add(matrix[i][k++]);
    		}
            k=++i;
            while (k<=m) {
            	result.add(matrix[k++][n]);
    		}
            k=--n;
            while (i<=m&&k>=j) {//注意i<=m
            	result.add(matrix[m][k--]);
    		}
            k=--m;
            while (j<=n&&k>=i) {//注意j<=n
            	result.add(matrix[k--][j]);
    		}
            j++;
        }
        return result;
    }
	
}
