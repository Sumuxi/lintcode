package com.lintcode149;

/**149. 买卖股票的最佳时机
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {
	
	/**枚举思想，贪心思想
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
    	int max = 0;
    	for (int i = 0; i<prices.length-1; i++) {
			if(prices[i+1]<=prices[i])
				continue;
			int t = findMax(prices, i+1)-prices[i];
			if(t>max)
				max = t;
		}
    	return max;
    }

	private int findMax(int[] prices, int index) {
		int max = prices[index];
		for (int i = index+1; i < prices.length; i++) {
			if(prices[i]>max)
				max = prices[i];
		}
		return max;
	}
    
}
