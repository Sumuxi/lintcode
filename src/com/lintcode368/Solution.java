package com.lintcode368;

/**368. 表达式求值
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
	 * Definition of ExpressionTreeNode
	 */
	static class ExpressionTreeNode {
	    public String symbol;
	    public ExpressionTreeNode left, right;
	    public ExpressionTreeNode(String symbol) {
	        this.symbol = symbol;
	        this.left = this.right = null;
	    }
	}
	
    /**使用辅助栈来建立表达式数
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
	
	/**计算表达式
     * @param expression: a list of strings
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
    	ExpressionTreeNode root = build(expression);
    	if(root==null)
    		return 0;
    	computeTree(root);
    	return Integer.parseInt(root.symbol);
    }

    //递归计算表达树
	private void computeTree(ExpressionTreeNode node) {
		if(node.left==null&&node.right==null)//叶子结点
			return;
		//因为这里都是二元运算符，所以非叶子结点一定都有左右子结点
		computeTree(node.left);
		computeTree(node.right);
		int left = Integer.parseInt(node.left.symbol);
		int right = Integer.parseInt(node.right.symbol);
		switch (node.symbol) {
		case "+":
			node.symbol = ""+(left+right);
			break;
		case "-":
			node.symbol = ""+(left-right);
			break;
		case "*":
			node.symbol = ""+(left*right);
			break;
		case "/":
			node.symbol = ""+(left/right);
			break;
		default:
			break;
		}
		node.left=null;
		node.right=null;
	}
    
}
