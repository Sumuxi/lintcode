package com.lintcode433;

/**433. 岛屿的个数
 * 挑战：	
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if(grid==null||grid.length==0)
        	return 0;
        int count = 0;
    	for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]==true){
					markGrid(grid, i, j);
					count++;
				}
			}
		}
    	return count;
    }

	private void markGrid(boolean[][] grid, int i, int j) {
		if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]==true)
			grid[i][j] = false;
		else
			return;
		markGrid(grid, i-1, j);
		markGrid(grid, i+1, j);
		markGrid(grid, i, j-1);
		markGrid(grid, i, j+1);
	}
	
}
