package com.lintcode807;

/**807. 回文数 II
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param n: non-negative integer n.
     * @return: return whether a binary representation of a non-negative integer n is a palindrome.
     */
	public boolean isPalindrome(int n) {
    	int i=30;
    	while(i>=0&&((n>>>i)&0x01)!=1){
    		i--;
    	}
    	int j=0;
    	while (i>j) {
    		if(((n>>>i--)&0x01)!=((n>>>j++)&0x01)){
    			return false;
    		}
		}
    	return true;
    }
	
}
