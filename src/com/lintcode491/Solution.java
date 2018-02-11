package com.lintcode491;

/**491. 回文数
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
	public boolean isPalindrome(int num) {
        String str = ""+num;
        int i=0, j=str.length()-1;
        while(i<j){
        	if(str.charAt(i)!=str.charAt(j))
        		return false;
        	i++;
        	j--;
        }
        return true;
    }
    
}
