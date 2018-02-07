package com.lintcode181;

/**181. 将整数A转换为B
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
	public int bitSwapRequired(int a, int b) {
        a = a^b;//异或
        int count = 0;
        for (int i = 0; i < 32; i++) {
			if ((a&0x01)>0) {
				count++;
			}
			a = a>>>1;
		}
        return count;
    }
	
}
