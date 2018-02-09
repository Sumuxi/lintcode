package com.lintcode401;

/**401. 排序矩阵中的从小到大第k个数
 * 挑战：使用O(k log n)的方法，n为矩阵的宽度和高度中的最大值
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().kthSmallest(
				new int[][]{{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}}, 19));
	}
	
	/**思路：利用类似于小顶堆的方法，将排序矩阵 matrix 化为小顶堆，即 matrix[0][0] 为矩阵中最小元素，
	 * 且矩阵每一行递增，每一列也递增，在取出堆顶元素后，将堆顶元素化为最大值 INT_MAX，
	 * 然后调整矩阵，使其符合小顶堆定义。如此一来，取出的第 k 个元素即排序矩阵中的从小到大第k个数
	 */
	/**类似于维持小顶堆，最小堆等数据结构的方法
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        int i=0;
        while (i<k-1) {
        	matrix[0][0] = Integer.MAX_VALUE;
        	adjustMatrix(matrix, 0, 0);
        	i++;
		}
        return matrix[0][0];
    }

	private void adjustMatrix(int[][] matrix, int i, int j) {
		int s = matrix[i][j];
		while (i < matrix.length - 1 && j < matrix[0].length - 1 
				&& s > matrix[i + 1][j] && s > matrix[i][j + 1]) {
			if (matrix[i + 1][j] < matrix[i][j + 1]) {
				matrix[i][j] = matrix[++i][j];
			} else {
				matrix[i][j] = matrix[i][++j];
			}
		}
		while (j < matrix[0].length - 1 && s > matrix[i][j + 1]) {
			matrix[i][j] = matrix[i][++j];
		}
		while (i < matrix.length - 1 && s > matrix[i + 1][j]) {
			matrix[i][j] = matrix[++i][j];
		}
	}
	
}
