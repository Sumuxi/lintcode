package com.lintcode394;

/**394. 硬币排成线
 * 挑战：O(1) 时间复杂度且O(1) 存储
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        return !(n%3==0);
    }
	
}
