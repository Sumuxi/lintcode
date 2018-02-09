package com.lintcode395;

/**395. 硬币排成线 II
 * 挑战：O(1) 时间复杂度且O(1) 存储
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
    	if(values.length<3)
    		return true;
    	take(sum1, sum2, values.length);
    	return sum1>sum2;
    }
    
    private int sum1=0, sum2=0;
    
	private boolean take(int[] values, int index, int n1, int n2) {
		if(index==values.length){
			return sum1>sum2;
		}
		
		for (int i=index; i<values.length&&i<index+n1; i++) {
			sum1+=values[i];
		}
		if(take(values, index)
		
	}
	
}
