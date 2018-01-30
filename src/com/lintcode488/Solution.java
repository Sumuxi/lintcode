package com.lintcode488;

import java.util.HashSet;

/** 488. 快乐数,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}
	
	/**快乐数各位之和或者以1结束，或者出现循环
     * @param n: An integer
     * @return: true if this is a happy number or false
     */
    public static boolean isHappy(int n) {
        // write your code here
    	int sum=0;
    	HashSet<Integer> set = new HashSet<Integer>();
    	set.add(n);
    	
    	while (true) {
    		int t;
			while (n>0) {
				t = n%10;
	    		sum += t*t;
	    		n=n/10;
			}
			if (sum==1) {
				return true;
			}
			if(set.contains(sum)){
				return false;
			}
			set.add(sum);
			n = sum;
			sum=0;
		}
    }
    
}
