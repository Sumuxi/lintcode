package com.lintcode518;

import java.util.ArrayList;

/** 518. 超级丑数,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(nthSuperUglyNumber(6, new int[]{2, 7, 13, 19}));
	}
	
	/**思想同 com.lintcode004
     * @param n: a positive integer
     * @param primes: the given prime list
     * @return: the nth super ugly number
     */
    public static int nthSuperUglyNumber(int n, int[] primes) {
        // write your code here
    	java.util.Arrays.sort(primes);
    	
    	ArrayList<Integer> list = new ArrayList<Integer>(n);
    	list.add(1);
    	list.add(primes[0]);
    	
    	ArrayList<Integer> tempNum = new ArrayList<Integer>();
    	int[] index = new int[primes.length];//索引数组
    	while (list.size()<n) {
    		
    		for (int i = 0; i < primes.length; i++) {
        		while (list.get(index[i])*primes[i]<=list.get(list.size()-1)) {
    				index[i]++;
    			}
        		tempNum.add(list.get(index[i])*primes[i]);
    		}
    		list.add(java.util.Collections.min(tempNum));
    		tempNum.clear();
		}
    	
    	return list.get(n-1);
    }
    
}
