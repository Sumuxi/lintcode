package com.lintcode001;

/** 1. A + B 问题,通过
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(aplusb(1024, -1023));
	}
	
	/* 思路：主要是利用二进制加法的原理来做，异或类似于加，与类似于进位，或也类似于加
	 * 
	 */
	
	/**
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
    
    /*
     * 思路：这个原理其实和上面的方法类似，主要看还有没有进位，有的话就继续循环，没有了就得到最终答案了
     */
    
    public int aplusb1(int a, int b) {
		// write your code here, try to do it without arithmetic operators.
		while (b != 0) {
			int sum = a ^ b;
			int carry = (a & b) << 1;
			a = sum;
			b = carry;
		}
		return a;
	}
    
}
