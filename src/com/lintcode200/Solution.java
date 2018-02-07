package com.lintcode200;

/**200. 最长回文子串
 * 挑战：O(n2) 时间复杂度的算法是可以接受的，如果你能用 O(n) 的算法那自然更好。
 * @author sumuxi
 *
 */
public class Solution {
    
	/**仅实现O(n2)
     * @param s: input string
     * @return: the longest plalindromic substring
     */
    public String longestPalindrome(String s) {
        String maxStr = "";
    	for (int i = 0; i < s.length(); i++) {
        	for (int j=s.length(); j>i; j--) {
				if(isHuiwenString(s, i, j)){
					if(j-i>maxStr.length())
						maxStr = s.substring(i, j);
					break;
				}
			}
		}
    	return maxStr;
    }

	private boolean isHuiwenString(String str, int i, int j) {
		j--;
		while(i<j){
			if(str.charAt(i++)!=str.charAt(j--)){
				return false;
			}
		}
		return true;
	}
	
	public String longestPalindrome1(String s) {
        String maxStr = "";
    	for (int i = 0; i < s.length()-maxStr.length(); i++) {
        	for (int j=s.length(); j>=i+maxStr.length(); j--) {
				if(isHuiwenString(s, i, j)){
					if(j-i>maxStr.length())
						maxStr = s.substring(i, j);
					break;
				}
			}
		}
    	return maxStr;
    }
	
}
