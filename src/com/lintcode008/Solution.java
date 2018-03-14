package com.lintcode008;

/** 8. 旋转字符串,AC
 * 挑战：在数组上原地旋转，使用O(1)的额外空间
 * @author sumuxi
 */
public class Solution {
	
	/*思路：按照offset分割字符串，0~offset-1做一次翻转操作，offset~tail做一次翻转操作，再对整个字符串做一次翻转操作，就是所要的结果
	 * 
	 */
	
	/**这种方法仅使用O(1)的空间
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
	public void rotateString(char[] str, int offset) {
		if (str == null || str.length <= 1) 
			return;
		
		int n = str.length;//取余数，防止数组索引越界
		offset %= n;
		reverse(str, 0, n - offset - 1);
		reverse(str, n - offset, n - 1);
		reverse(str, 0, n - 1);
	}

	private void reverse(char[] str, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
		}
	}
	
	/**这种方法利用了额外的空间，没有达到挑战要求
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public static void rotateString1(char[] str, int offset) {
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
