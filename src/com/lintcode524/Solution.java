package com.lintcode524;

/**524. 左填充
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param originalStr: the string we want to append to with spaces
     * @param size: the target length of the string
     * @return: A string
     */
    public static String leftPad(String originalStr, int size) {
        StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < size-originalStr.length(); i++) {
			sb.append(' ');
		}
    	return sb.append(originalStr).toString();
    }

    /**
     * @param originalStr: the string we want to append to
     * @param size: the target length of the string
     * @param padChar: the character to pad to the left side of the string
     * @return: A string
     */
    public static String leftPad(String originalStr, int size, char padChar) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < size-originalStr.length(); i++) {
			sb.append(padChar);
		}
    	return sb.append(originalStr).toString();
    }
    
}
