package com.lintcode423;

/**423. 有效的括号序列
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	switch (ch) {
			case '(':
			case '[':
			case '{':
				stack.push(ch);
				break;
			case ')':
				if(!stack.isEmpty()&&stack.peek()=='('){
					stack.pop();
					break;
				}
				else
					return false;
			case ']':
				if(!stack.isEmpty()&&stack.peek()=='['){
					stack.pop();
					break;
				}
				else
					return false;
			case '}':
				if(!stack.isEmpty()&&stack.peek()=='{'){
					stack.pop();
					break;
				}
				else
					return false;
			}
		}
        if(stack.isEmpty())
        	return true;
        return false;
    }
	
}
