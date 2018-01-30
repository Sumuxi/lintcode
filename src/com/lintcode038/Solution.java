package com.lintcode038;

/**
 * 36. 翻转链表 II
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution());
	}

	//挑战：要求O(m+n) 时间复杂度和O(1) 额外空间
	private int meiyoushixian;
	
	/** 斜对角线是排序的，可以从 matrix[m-1][n-1]向matrix[0][0]搜索
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
    	if (matrix.length==0) {
			return 0;
		}
    	int m = matrix.length;//行数
    	int n = matrix[0].length;//列数
    	
    	for (int i=m-1,j=n-1;;) {
			if (target>=matrix[i][j]) {
				break;
			}
    		if(i==0&&j==0) break;
    		if(i>0) i--;
			if(j>0) j--;
		}
    	
    	
    	return -1;
    }
    
    //简单实现
    public int searchMatrix1(int[][] matrix, int target) {
    	if (matrix.length==0) {
			return 0;
		}
    	
    	int count = 0;
    	for (int i = 0; i < matrix.length; i++) {
			if(java.util.Arrays.binarySearch(matrix[i], target)>=0) count++;
		}
    	return count;
    }
	
}
