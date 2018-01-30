package com.lintcode109;

/**109. 数字三角形
 *  挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().minimumTotal(new int[][] { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } }));
	}

	/**对于上一层的数，只有两条路径可走，那么，从下往上走，每次只把小的数给上一层，就可以收缩路径
	 * @param triangle:
	 *            a list of lists of integers
	 * @return: An integer, minimum path sum
	 */
	public int minimumTotal(int[][] triangle) {
		if(triangle.length==1){
			return triangle[0][0];
		}
		
		//triangle.length>=2
		for (int i=triangle.length-2; i>=0; i--) {
			for (int j = 0; j < triangle[i].length; j++) {
				triangle[i][j] = triangle[i+1][j]<triangle[i+1][j+1]?
						triangle[i][j]+triangle[i+1][j]:triangle[i][j]+triangle[i+1][j+1];
			}
		}
		return triangle[0][0];
	}
	
	
	/**递归求解，相当于列出所有路径和，超时
	 * @param triangle:
	 *            a list of lists of integers
	 * @return: An integer, minimum path sum
	 */
	private int min = Integer.MAX_VALUE;
	public int minimumTotal1(int[][] triangle) {

		calculate(triangle, 0, 1, triangle[0][0]);

		return min;
	}

	private void calculate(int[][] triangle, int index, int floor, int sum) {
		if (floor == triangle.length) {
			if (sum < min)
				min = sum;
			return;
		}

		calculate(triangle, index, floor + 1, sum + triangle[floor][index]);
		calculate(triangle, index + 1, floor + 1, sum + triangle[floor][index + 1]);
	}
}
