package com.lintcode422;

/**422. 最后一个单词的长度
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param s: A string
     * @return: the length of last word
     */
    public int lengthOfLastWord(String s) {
    	int i=s.length()-1;
    	while(i>=0&&s.charAt(i)==' '){
    		i--;
    	}
    	int j=i;
    	while(j>=0&&s.charAt(j)!=' '){
    		j--;
    	}
    	return i-j;
    }
	
}
