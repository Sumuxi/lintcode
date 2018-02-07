package com.lintcode212;

/**212. 空格替换 
 * 挑战：在原字符串(字符数组)中完成替换，不适用额外空间
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
	public int replaceBlank(char[] array, int length) {
    	int sumOfChar = 0;
    	for (int i = 0; i < length; i++) {
			if(array[i]==' ')
				sumOfChar++;
		}
    	int j = length+2*sumOfChar;
    	int result = j;
    	for (int i=length-1; i>=0; i--) {
			if(array[i]==' '){
				array[--j] = '0';
				array[--j] = '2';
				array[--j] = '%';
			}else {
				array[--j] = array[i];
			}
		}
    	return result;
    }
    
}
