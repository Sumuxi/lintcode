package com.lintcode407;

/**407. 加一
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        int sum=0;//本位和
        int p = 1;//低位向本位的进位
        for (int i=digits.length-1; i>=0; i--) {
			sum = digits[i]+p;
			if(sum>=10){
				digits[i]=0;//因为只是加1，此时sum只可能为10,故digits[i]=0
				p=1;
			}else {
				digits[i] = sum;
				p=0;
				return digits;
			}
		}
        //p==1
        int result[] = new int[digits.length+1];
    	result[0] = p;
    	System.arraycopy(digits, 0, result, 1, digits.length);
    	return result;
    }
		
}
