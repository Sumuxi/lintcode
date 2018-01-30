package com.lintcode004;

import java.util.ArrayList;

/** 4. 丑数 II
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1665));
	}
	
	/**
     * @param n: An integer
     * @return: the nth prime number as description.
	 * @throws Exception 
     */
    public static int nthUglyNumber1(int n) {
    	if (n<=0) {
			throw new RuntimeException("invalid parameter！");
		}
    	if (n<7) {
			return n;
		}
    	int[] arr = new int[n];
    	int index = 0;
    	for (; index < 5; index++) {
			arr[index] = index+1;
		}
    	
    	arr[index++] = arr[1]*arr[2];
    	
    	return 0;
    }
    
    /** 对所有数,穷尽分析的方法，超时
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
    	if (n<=0) {
			throw new RuntimeException("invalid parameter！");
		}
    	if (n<7) {
			return n;
		}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i < 6; i++) {//添加1~6
			list.add(i+1);
		}
    	
    	int count=8;
    	int num;
    	while (list.size()<n) {
    		num=count++;
    		if (isUglyNumber(num)) {
    			list.add(num);
			}
		}
    	
//    	for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i)+" ");
//		}
    	return list.get(n-1);
    }

	public static boolean isUglyNumber(int num) {
		// TODO Auto-generated method stub
		while (num!=1) {
			if (num%2==0) {
				num/=2;
			}else if (num%3==0) {
				num/=3;
			}else if (num%5==0) {
				num/=5;
	    	}else {
				return false;
			}
		}
		return true;
	}
    
}
