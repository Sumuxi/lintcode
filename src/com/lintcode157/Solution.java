package com.lintcode157;

/**157. 判断字符串是否没有重复字符
 * 挑战：如果不使用额外的存储空间，你的算法该如何改变？
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param str: A string
     * @return: a boolean
     */
	public boolean isUnique(String str) {
        if(str==null||str.length()<=1)
        	return true;
    	for (int i=0; i<str.length()-1; i++) {
			for (int j=i+1; j<str.length(); j++) {
				if(str.charAt(j)==str.charAt(i))
					return false;
			}
		}
    	return true;
    }
    
}
