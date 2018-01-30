package com.lintcode078;

/**78. 最长公共前缀
 * 
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}
	
	/**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
    	if(strs==null||strs.length == 0)
    		return "";
    	
    	int i = 0;
    	if(strs[0].length()==0){
    		return "";
    	}
    	a:while (i<strs[0].length()) {
    		char ch = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if(i>=strs[j].length()||strs[j].charAt(i) != ch){
					break a;
				}
			}
			i++;
		}
    	return strs[0].substring(0, i);
    }

}
