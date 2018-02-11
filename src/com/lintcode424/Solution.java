package com.lintcode424;

/**424. 逆波兰表达式求值
 * 挑战：	
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param tokens: The Reverse Polish Notation
     * @return: the value
     */
    public int evalRPN(String[] tokens) {
    	java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
    	int t1, t2;//两个操作数
    	for (int i = 0; i < tokens.length; i++) {
			switch (tokens[i]) {
			case "+":
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1+t2);
				break;
			case "-":
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1-t2);
				break;
			case "*":
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1*t2);
				break;
			case "/":
				t2 = stack.pop();
				t1 = stack.pop();
				stack.push(t1/t2);
				break;
			default:
				stack.push(Integer.parseInt(tokens[i]));
				break;
			}
		}
    	return stack.pop();
    }
	
}
