package com.lintcode008;

/** 8. 旋转字符串,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		char[] str = "abcdefg".toCharArray();
		rotateString(str, 7);
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
	}
	
	/**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public static void rotateString(char[] str, int offset) {
    	if(offset<0){//offset非负
    		throw new RuntimeException("offset < 0");
    	}
    	if(str.length<0){//str.length非负
    		throw new RuntimeException("str.length <= 0");
    	}
    	if(str.length<=1){
    		return;
    	}
    	offset = offset%str.length;//取余数，防止数组索引越界
    	if (offset == 0) {
			return;
		}
    	
    	char[] arr = new char[offset];
    	for (int i=arr.length-1, j=str.length-1; i>=0; i--,j--) {
			arr[i]=str[j];
		}
    	for (int i=str.length-offset-1; i>=0; i--) {
			str[i+offset] = str[i];
		}
    	for (int i=0, j=0; i<arr.length; i++,j++) {
			str[j]=arr[i];
		}
    }
	
}
