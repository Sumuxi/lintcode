package com.lintcode161;

/**161. 旋转图像
 * 挑战：能否在原地完成？
 * @author sumuxi
 *
 */
public class Solution {
    
	/**N×N, 从最外圈开始，一圈一圈地转
     * @param matrix: a lists of integers
     * @return: 
     */
    public void rotate(int[][] matrix) {
    	int n = matrix.length-1;
    	int t;
        for (int i = 0; i < matrix.length/2; i++) {
        	for (int j = i; j < n-i; j++) {
        		t = matrix[i][j];
    			matrix[i][j] = matrix[n-j][i];
    			matrix[n-j][i] = matrix[n-i][n-j];
    			matrix[n-i][n-j] = matrix[j][n-i];
    			matrix[j][n-i] = t;
    		}
		}
    }
    
}
