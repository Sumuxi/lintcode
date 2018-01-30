package com.lintcode002;

/** 2. 尾部的零,通过
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(trailingZeros(11));
	}
	
	/*
     * @param : An integer
     * @param : An integer
     * @return: The sum of a and b
     */
    public static long trailingZeros1(long n){//超时
    	
    	long index = 5;
    	long num;
    	long count = 0;
    	while (index<=n) {
			
    		num = index;
//    		System.out.print("num:count "+num);//
//    		count=0;//
    		while (num%5==0) {
				count++;
				num = num/5;
			}
//    		System.out.println(" "+count);//
    		index +=5;
		}
    	
    	return count;
    }
    
    public static long trailingZeros(long n){
    	
    	long count = 0;
    	String num = Long.toString(n, 5);
    	for (int i = 0; i<num.length(); i++) {
			int d = num.charAt(i)-'0';
			count += (long)(d*(Math.pow(5, num.length()-1-i) -1)/4);
		}
    	
    	return count;
    }
}
