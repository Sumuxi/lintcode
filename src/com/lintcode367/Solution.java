package com.lintcode367;

/**367. 表达树构造
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
	
	static class ExpressionTreeNode {
	    public String symbol;
	    public ExpressionTreeNode left, right;
	    public ExpressionTreeNode(String symbol) {
	        this.symbol = symbol;
	        this.left = this.right = null;
	    }
	}
	
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
	public ExpressionTreeNode build(String[] expression) {
        java.util.Stack<String> signs = new java.util.Stack<String>();//符号栈
        java.util.Stack<ExpressionTreeNode> tree = new java.util.Stack<ExpressionTreeNode>();//表达树
        ExpressionTreeNode node=null; 
        for (int i = 0; i < expression.length; i++) {
			switch (expression[i]) {
			case "+":
			case "-":
				//非空且栈顶不为"("时要循环出栈
				while(!(signs.isEmpty()||signs.peek().equals("("))){
					node = new ExpressionTreeNode(signs.pop());
					node.right = tree.pop();//第二操作数
					node.left = tree.pop();//第一操作数
					tree.push(node);
				}
				signs.push(expression[i]);
				break;
			case "*":
			case "/":
				//非空且栈顶为"*"or"/"出栈
				if(!signs.isEmpty()&&(signs.peek().equals("*")||signs.peek().equals("/"))){
					node = new ExpressionTreeNode(signs.pop());
					node.right = tree.pop();//第二操作数
					node.left = tree.pop();//第一操作数
					tree.push(node);
				}
				signs.push(expression[i]);
				break;
			case "(":
				signs.push(expression[i]);
				break;
			case ")":
				//循环出栈直到栈顶为"("
				while(!signs.isEmpty()&&!signs.peek().equals("(")){
					node = new ExpressionTreeNode(signs.pop());
					node.right = tree.pop();//第二操作数
					node.left = tree.pop();//第一操作数
					tree.push(node);
				}
				signs.pop();
				break;
			default://操作数
				tree.push(new ExpressionTreeNode(expression[i]));
				break;
			}
		}
        while (!signs.isEmpty()) {
        	node = new ExpressionTreeNode(signs.pop());
			node.right = tree.pop();//第二操作数
			node.left = tree.pop();//第一操作数
			tree.push(node);
		}
		if(tree.isEmpty())
		    return null;
        return tree.peek();
    }
    
}
/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */