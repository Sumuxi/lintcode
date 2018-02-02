package com.lintcode158;

/**158. 两个字符串是变位词
 * 挑战：O(n) time, O(1) extra space
 * @author sumuxi
 *
 */
public class Solution {
    
	/**O(nlogn)*2+O(n)
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        if(s.length()!=t.length())
        	return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]!=arr2[i])
				return false;
		}
        return true;
    }
    
}
