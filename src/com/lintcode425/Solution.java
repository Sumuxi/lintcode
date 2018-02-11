package com.lintcode425;

import java.util.List;

/**425. 电话号码的字母组合
 * 挑战：	
 * @author sumuxi
 *
 */
public class Solution {

	/**递归与回溯
     * @param digits: A digital string
     * @return: all possible letter combinations
     */
	public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return result;
    	java.util.HashMap<Character, chart> map 
    	= new java.util.HashMap<Character, chart>();
    	map.put('2', new chart("abc",0));
    	map.put('3', new chart("def",0));
    	map.put('4', new chart("ghi",0));
    	map.put('5', new chart("jkl",0));
    	map.put('6', new chart("mno",0));
    	map.put('7', new chart("pqrs",0));
    	map.put('8', new chart("tuv",0));
    	map.put('9', new chart("wxyz",0));
    	char[] arr = new char[digits.length()];
    	int i=0;
    	int j=0;
    	addChar(map, arr, i, digits, j);
    	return result;
    }
    
    List<String> result = new java.util.ArrayList<String>();
    
	private void addChar(java.util.HashMap<Character, chart> map, 
			char[] arr, int i, String digits, int j) {
		if(j==digits.length()){
			result.add(new String(arr));
			return;
		}
		
		chart t = new chart(map.get(digits.charAt(j)));
		while (t.index<t.str.length()) {
			arr[i] = t.str.charAt(t.index);
			t.index++;
			addChar(map, arr, i+1, digits, j+1);
		}
		
	}
	
	public static class chart{
    	int index;
    	String str;
		public chart(String str, int index) {
			super();
			this.index = index;
			this.str = str;
		}
		
		public chart(chart obj) {
			this(obj.str, obj.index);
		}
    }
	
}
