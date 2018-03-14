package com.lintcode037;

/**37. 反转一个3位整数
 * 
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        int result = 0;
        for(int i=0;i<3;i++){
            result = result*10+number%10;
            number=number/10;
        }
        return result;
    }
	
}
