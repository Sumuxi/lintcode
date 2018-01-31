package com.lintcode151;

/**151. 买卖股票的最佳时机 III
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
    	int max1 = 0;
    	int max2 = 0;
    	int max3 = 0;
    	int max4 = 0;
    	for (int i = 0; i<prices.length-1; i++) {
			if(prices[i+1]<=prices[i])
				continue;
			int index = findMax(prices, i+1);
			
			int k=i;
			while(k<index) {
	    		int j = k+1;
	    		while(j<prices.length&&prices[j]>=prices[j-1]){//是递增的
	    			j++;
	    		}
	    		int t1 = prices[j-1]-prices[k];
	    		if(t1>max3){
	    			max4 = max3; 
					max3 = t1;
	    		}else if (t1>max4) {
					max4 = t1;
				}
	    		k=j;
			}
			int t = prices[index] - prices[i];
			if(max3>t){
				if(max3>max1){
					if(max4>max2){
						max1 = max3;
						max2 = max4;
					}else {
						max2 = max1;
						max1 = max3;
					}
				}else if(max3>max2){
					max2 = max3;
				}
				
			}else {
				if(t>max1){
					max2 = max1; 
					max1 = t;
				}else if (t>max2) {
					max2 = t;
				}
			}
			i = index;
		}
    	return max1+max2>max3+max4?max1+max2:max3+max4;
    }

	private int findMax(int[] prices, int index) {
		int max = prices[index];
		int maxIndex = index;
		for (int i = index+1; i < prices.length; i++) {
			if(prices[i]>max){
				max = prices[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
    
}
