package com.lintcode370;

import java.util.List;

/**370. 将表达式转换为逆波兰表达式
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public List<String> convertToRPN(String[] expression) {
    	List<String> result = new java.util.ArrayList<String>();
        java.util.Stack<String> stack = new java.util.Stack<String>();
        for (int i = 0; i < expression.length; i++) {
			switch (expression[i]) {
			case "+":
			case "-":
				//非空且栈顶不为"("时要循环出栈
				while(!(stack.isEmpty()||stack.peek().equals("("))){
					result.add(stack.pop());
				}
				stack.push(expression[i]);
				break;
			case "*":
			case "/":
				//非空且栈顶为"*"or"/"出栈
				if(!stack.isEmpty()&&(stack.peek().equals("*")||stack.peek().equals("/"))){
					result.add(stack.pop());
				}
				stack.push(expression[i]);
				break;
			case "(":
				stack.push(expression[i]);
				break;
			case ")":
				//循环出栈直到栈顶为"("
				while(!stack.isEmpty()&&!stack.peek().equals("(")){
					result.add(stack.pop());
				}
				stack.pop();
				break;
			default:
				result.add(expression[i]);
				break;
			}
		}
        while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
        return result;
    }
	
}
