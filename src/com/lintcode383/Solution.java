package com.lintcode383;

/**383. 装最多水的容器
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param heights: a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
    	int max = 0;
        for (int i = 0; i < heights.length-1; i++) {
			for (int j = i+1; j < heights.length; j++) {
				int height = heights[i]<heights[j]?heights[i]:heights[j];
				if(height*(j-i)>max)
					max = height*(j-i);
			}
		}
        return max;
    }
	
}
