package com.lintcode366;

/**366. 斐波纳契数列
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
    	int f1 = 0;
    	int f2 = 1;
    	int i = 1;
    	while(i<n){
    		f2 = f2+f1;
    		f1 = f2-f1;
    		i++;
    	}
    	return f1;
    }
	
}
