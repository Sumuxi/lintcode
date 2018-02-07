package com.lintcode185;

/**185. 矩阵的之字型遍历
 * 挑战：在 O(nlogn) 的时间复杂度内完成
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param matrix: An array of integers
     * @return: An array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int result[] = new int[m*n];
    	int k=0;
    	boolean flag = true;
    	for (int s=0; s<=m+n-2; s++) {
    		int i;
    		if(flag){//向右上
    			if(s<m)
        			i = s;
        		else
        			i = m-1;
    			while (i>=0&&s-i<n) {
    				result[k++] = matrix[i][s-i];
    				i--;
				}
    			flag = false;
    		}
        	else{//向左下
        		if(s<n)
        			i = s;
        		else
        			i = n-1;
    			while (i>=0&&s-i<m) {
    				result[k++] = matrix[s-i][i];
    				i--;
				}
        		flag = true;
        	}
		}
    	return result;
    }
	
}
