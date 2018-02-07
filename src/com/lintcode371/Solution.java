package com.lintcode371;

import java.util.ArrayList;

/**371. 用递归打印数字
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param n: An integer
     * @return: An array storing 1 to the largest number with n digits
     */
    public ArrayList<Integer> numbersByRecursion(int n) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(n==0)
    		return list;
    	recursion(list, 1, 1, n);
    	return list;
    }

	private void recursion(ArrayList<Integer> list,int i, int j, int n) {
		int t = (int)Math.pow(10, j);
		while(i<t){
			list.add(i++);
		}
		if(j==n){
			return;
		}
		recursion(list, t, j+1, n);
	}
    
}
