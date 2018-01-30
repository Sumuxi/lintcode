package com.lintcode122;

/**122. 直方图最大矩形覆盖
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {
	
	/**左右扫描，不是最好的方法
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
	public int largestRectangleArea(int[] height) {
        if(height==null||height.length==0)
        	return 0;
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
			int count = 1;
			int j=i+1;
			while (j<height.length&&height[j]>=height[i]) {
				count++;
				j++;
			}
			j=i-1;
			while (j>=0&&height[j]>=height[i]) {
				count++;
				j--;
			}
			int t;
			if((t=count*height[i])>max)
				max = t;
		}
        return max;
    }
    
}
