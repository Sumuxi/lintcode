package com.lintcode150;

/**150. 买卖股票的最佳时机 II
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {
	
	/**找出所有递增的区域，累和即可
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
	public int maxProfit(int[] prices) {
    	int max = 0;
    	int i = 0;
    	while(i<prices.length-1) {
    		int j = i+1;
    		while(j<prices.length&&prices[j]>=prices[j-1]){//是递增的
    			j++;
    		}
    		max += prices[j-1]-prices[i];
    		i=j;
		}
    	return max;
    }

}
