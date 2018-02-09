package com.lintcode415;

/**415. 有效回文串
 * 挑战：O(n) 时间复杂度，且不占用额外空间
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
	public boolean isPalindrome(String s) {
        //s!=null
    	if(s=="")
    		return true;
    	s = s.toLowerCase();
    	int i=0;
    	int j=s.length()-1;
    	while (i<j) {
    		while(i<j&&!((s.charAt(i)>='0'&&s.charAt(i)<='9')
    				||(s.charAt(i)>='a'&&s.charAt(i)<='z'))){
    			i++;
			}
    		while(i<j&&!((s.charAt(j)>='0'&&s.charAt(j)<='9')
    				||(s.charAt(j)>='a'&&s.charAt(j)<='z'))){
    			j--;
			}
    		if(i<j&&s.charAt(i++)!=s.charAt(j--)){
    			return false;
    		}
		}
    	return true;
    }
	
}
