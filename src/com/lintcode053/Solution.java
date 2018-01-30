package com.lintcode053;

/**53. 翻转字符串
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().reverseWords("   4   world dfdsf    "));
	}
	
	private int start;
	private int end;
	
	/**
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
    	if(s.equals("")||s==null) return "";
    	
    	end = s.length()-1;
    	
    	StringBuilder sb = new StringBuilder();
//    	String word = null;
        while (end>=0) {
//        	if(!(word=nextWord(s)).equals(""))
        		
        	sb.append(nextWord(s)+" ");
        	end = --start;
		}
        return sb.substring(0, sb.length()-1);
    }

	private String nextWord(String s) {
		while (end>=0&&s.charAt(end)==' ') {
			end--;
		}
		start = end;
		
		while (start>=0&&s.charAt(start)!=' ') {
			start--;
		}
		start++;
		return s.substring(start, end+1);
	}
	
}
