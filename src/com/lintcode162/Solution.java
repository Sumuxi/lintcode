package com.lintcode162;

import java.util.Iterator;

/**162. 矩阵归零
 * 挑战：你是否使用了额外的空间？
 * 一个直接的解决方案是使用 O(MN) 的额外空间，但这并不是一个好的方案。
 * 一个简单的改进方案是使用 O(M + N) 的额外空间，但这仍然不是最好的解决方案。 
 * 你能想出一个常数空间的解决方案吗？
 * @author sumuxi
 *
 */
public class Solution {
    
	/**使用 O(M+N)的额外空间
     * @param matrix: A list of lists of integers
     * @return: 
     */
    public void setZeroes(int[][] matrix) {
    	java.util.HashSet<Integer> rows = new java.util.HashSet<Integer>();
    	java.util.HashSet<Integer> columns = new java.util.HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j]==0){
        			rows.add(i);
        			columns.add(j);
        		}
    		}
		}
        //行
        for (Iterator<Integer> iterator = rows.iterator(); iterator.hasNext();) {
			Integer i = iterator.next();
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
        //列
        for (Iterator<Integer> iterator = columns.iterator(); iterator.hasNext();) {
			Integer i = iterator.next();
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][i] = 0;
			}
		}
    }
    
}
