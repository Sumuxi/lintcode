package com.lintcode115;

/**115. 不同的路径 II
 *  挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}
	
	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0){
        	return 0;
        }
        
        int m = obstacleGrid.length;//行
        int n = obstacleGrid[0].length;//列
        
        if(obstacleGrid[0][0] == 1)
        	return 0;
        
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i=1; i < arr.length; i++) {
			if(obstacleGrid[0][i]==0&&arr[i-1]>0)
				arr[i] = 1;
			else
				arr[i] = 0;
		}
        
        for (int i = 1; i < m; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(obstacleGrid[i][j]==0){
					if(j==0){
						continue;
					}
					if(arr[j-1]>0){
						if(arr[j]>0)
							arr[j] += arr[j-1];
						else
							arr[j] = arr[j-1];
					}
				}else {
					arr[j] = 0;
				}
			}
		}
        return arr[arr.length-1];
    }

}
