package com.lintcode427;

import java.util.List;

/**427. 生成括号
 * 挑战：	
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new java.util.ArrayList<String>();
    	char[] arr = new char[2*n];
        addBrackets(result, arr, 0, 0, n);
        return result;
    }

	private void addBrackets(List<String> result, char[] arr, int i, int j, int n) {
		if(j==n){
			if(n>0){
				while(i<arr.length)
					arr[i++]=')';
				result.add(new String(arr));
			}
			return;
		}
		
		arr[i]='(';
		addBrackets(result, arr, i+1, j+1, n);//添加子节点
		if(n>1){
			arr[++i]=')';
			addBrackets(result, arr, i+1, j+1, n);//添加兄弟结点
		}
	}
	
}
