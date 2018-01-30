package com.lintcode517;


/** 517. 丑数,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(isUgly(0));
	}
	
	/**
     * @param num: An integer
     * @return: true if num is an ugly number or false
     */
    public static boolean isUgly(int num) {
        // write your code here
    	if (num<=0) {
			return false;
		}
    	while (num%2==0) num = num/2;
    	while (num%3==0) num = num/3;
    	while (num%5==0) num = num/5;
    	if (num==1) {
			return true;
		}else {
			return false;
		}
    }
    
}
