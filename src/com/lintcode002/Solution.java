package com.lintcode002;

/**
 * 2. 尾部的零,通过
 * 
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(Long.toString(11l, 5));
		System.out.println(trailingZeros(11));
	}

	/* 思路：
	 * 这个题的主要思路是找n的阶乘中的10的因子个数，其实就是找5的因子个数（对于阶乘，因子2一定多于因子5的个数）
	 * 这些因子就包含在1~n中，如果把n转成5进制，会发现0的个数和n的5进制数有一个规律，按照这个规律来做题
	 */

	/*
	 * @param : An integer
	 * 
	 * @param : An integer
	 * 
	 * @return: The sum of a and b
	 */
	public static long trailingZeros1(long n) {// 超时

		long index = 5;
		long num;
		long count = 0;
		while (index <= n) {

			num = index;
			// System.out.print("num:count "+num);//
			// count=0;//
			while (num % 5 == 0) {
				count++;
				num = num / 5;
			}
			// System.out.println(" "+count);//
			index += 5;
		}

		return count;
	}

	public static long trailingZeros2(long n) {

		long count = 0;
		String num = Long.toString(n, 5);
		for (int i = 0; i < num.length(); i++) {
			int d = num.charAt(i) - '0';
			count += (long) (d * (Math.pow(5, num.length() - 1 - i) - 1) / 4);
		}

		return count;
	}

	public static long trailingZeros(long n) {
		assert n>0;
		n /= 5;
		long count = 1;//中间要加的次数
		int i=1;//主要用来表示n/5>0的次数，没必要用long
		long result=0;
		while(n>0){
			result += (n%5)*count;
			count += Math.pow(5, i++);
			n /= 5;
		}
		return result;
	}
}
