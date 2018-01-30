package com.lintcode028;

/**
 * 28. 搜索二维矩阵
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

		System.out.println(new Solution().searchMatrix(new int[][]{
			  {1, 3, 5, 7},
			  {10, 11, 16, 20},
			  {23, 30, 34, 50}}, 31));
	}
	
	/**二分查找法, log(n)
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
    	if (matrix.length==0) {
			return false;
		}
    	//按照题目的描述，可以认为第二维数组如果有，则长度一定>=1;
    	int start = 0;
    	int end = matrix.length-1;
    	int mid;
    	int index=0;
    	while (start<=end) {
			mid = (start+end)/2;
			if (target<matrix[mid][0]) {//左
				end = mid-1;
			}else if (target>matrix[mid][0]) {//右
				start = mid+1;
			}else {//== 已找到
				return true;
			}
		}
    	index = start;
    	if (index == 0) {
			index = 1;
		}
    	
    	if(java.util.Arrays.binarySearch(matrix[index-1], target)>=0){
    		return true;
    	}else {
			return false;
		}
    }

}

