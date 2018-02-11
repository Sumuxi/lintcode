package com.lintcode627;

/**627. 最长回文串
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        java.util.HashMap<Character, Integer> map = new java.util.HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
        	if(map.containsKey(c)){
        		map.put(c, map.get(c)+1);
        	}else {
				map.put(c, 1);
			}
		}
        int result = 0;
        boolean flag = false;//是否有奇数
        for (java.util.Iterator<java.util.Map.Entry<Character, Integer>> iterator 
        		= map.entrySet().iterator(); iterator.hasNext();) {
			java.util.Map.Entry<Character, Integer> entry = 
					iterator.next();
			if((entry.getValue()&0x01)==1){//奇数
				result+=entry.getValue()-1;
				flag = true;
			}else {
				result+=entry.getValue();
			}
		}
        if(flag)
        	return result+1;
        return result;
    }
    
}
