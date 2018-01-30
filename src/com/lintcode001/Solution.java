package com.lintcode001;

/** 1. A + B 问题,通过
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(aplusb(1024, -1023));
	}
	
	/*
     * @param : An integer
     * @param : An integer
     * @return: The sum of a and b
     */
    public static int aplusb(int a, int b) {
        // write your code here
    	
    	int opt1;//操作数1最低位
    	int opt2;//操作数2最低位
    	
    	int s;//本位和
    	int co;//本位向高位的进位
    	int ci=0;//低位向本位的进位
    	
    	int sum = 0;
    	for (int i = 0; i < 32; i++) {
			opt1 = (a>>i)&0x01;
			opt2 = (b>>i)&0x01;
			
			s = opt1^opt2^ci;
			co = (opt1&opt2)|(opt1&ci)|(opt2&ci);
			sum=sum|(s<<i);
			ci = co;
		}
    	
    	return sum;
    }
    
}
