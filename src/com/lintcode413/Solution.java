package com.lintcode413;

/**413. 反转整数
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().reverseInteger
				(1534236469));
		System.out.println(964632435*10);
	}
	
	/**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
	public int reverseInteger(int n) {
        int sign=1;
        if(n<0){
        	sign = -1;
        	n = -n;
        }
        //n一定>=0
        int r = 0;
        while (n>0) {
        	int t = r;
        	for (int i=0; i<10; i++) {
				if(Integer.MAX_VALUE-t<r){//检测溢出
					return 0;
				}
				r+=t;
			}
        	if(Integer.MAX_VALUE-r<n%10){//检测溢出
				return 0;
			}
			r += n%10;
        	n=n/10;
		}
        return sign*r;
    }
	
	public int reverseInteger1(int n) {
        int sign=1;
        if(n<0){
        	sign = -1;
        	n = -n;
        }
        //n一定>=0
        long r = 0;
        while (n>0) {
			r = r*10+n%10;
        	if(r>Integer.MAX_VALUE)//int溢出
        		return 0;
        	n=n/10;
		}
        return (int)(sign*r);
    }
	
}
