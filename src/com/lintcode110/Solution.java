package com.lintcode110;

/**110. 最小路径和
 *  挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}

	/**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0)
        	return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int k = m+n-1;
        if(k<=1){
        	return grid[0][0];
        }
        
        for (int s = 1; s < k; s++) {
        	int i=0;
        	while (i<=s) {
        		if(i<m&&s-i<n){
        			if (i-1>=0&&s-i-1<0) {//列越界
    					grid[i][s-i] += grid[i-1][s-i]; 
    				}else if (i-1<0&&s-i-1>=0) {//行越界
    					grid[i][s-i] += grid[i][s-i-1];
    				}else if (i-1>=0&&s-i-1>=0) {//都没越界
    					grid[i][s-i] += grid[i-1][s-i]<grid[i][s-i-1]?grid[i-1][s-i]:grid[i][s-i-1];
    				}
        		}
				i++;
			}
		}
        return grid[m-1][n-1];
    }
}
