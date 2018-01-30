package com.lintcode055;

/**55. 比较字符串
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution());
	}
	
	/**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if(B.length()==0) return true;
        if(A.length()<B.length()) return false;
        
        StringBuilder sb = new StringBuilder(A);
        int index;
        for (int i=0; i<B.length(); i++) {
			if ( (index=sb.indexOf(""+B.charAt(i))) >=0) {// !=-1, 这两种方式没什么区别
				sb.deleteCharAt(index);
			}else {
				return false;
			}
		}
        return true;
    }
	
}
