package com.lintcode068;

import java.util.List;

/**
 * 68. 二叉树的后序遍历
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(3);
//		root.right = new TreeNode(4);
//		root.right.right= new TreeNode(5);
		System.out.println(new Solution().postorderTraversal(root));
	}
	
	//嵌套类
	private static class Node{
		TreeNode treeNode;
		boolean flag;//是否遍历了右子节点,使用一个计数器应该也可以
		
		public Node(TreeNode treeNode, boolean flag) {
			super();
			this.treeNode = treeNode;
			this.flag = flag;
		}
		
	}
	
	/**非递归方法实现，注意一个结点两次进栈，两次出栈,需记录当前进栈节点的右子节点是否被访问过
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        java.util.Stack<Node> stack = new java.util.Stack<Node>();
        List<Integer> result = new java.util.ArrayList<Integer>();
        
        Node node = null;//
        out:while (true) {
			if (root!=null) {
				stack.push(new Node(root, false));
				root = root.left;
			}else if (stack.isEmpty()) {
				break;
			}else {
				while(!stack.isEmpty()&&(node=stack.pop()).flag) {//注意是 while
					result.add(node.treeNode.val);
					if (stack.isEmpty()) {
						break out;//跳出外层循环
					}
				}
				node.flag = true;//马上就要遍历右子树了
				stack.push(node);
				root = node.treeNode.right;
			}
		}
        return result;
    }
	
	/**递归方法实现
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        // write your code here
        List<Integer> result = new java.util.ArrayList<Integer>();
        travelTree(result, root);
        return result;
    }

    /**java的引用传递的仅仅是该引用的副本
     * @param result
     * @param node
     */
    private void travelTree(List<Integer> result, TreeNode node) {
		if (node==null) {
			return;
		}
		travelTree(result, node.left);//左
		travelTree(result, node.right);//右
		result.add(node.val);//根
	}

}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 public int val;
 public TreeNode left, right;
 public TreeNode(int val) {
     this.val = val;
     this.left = this.right = null;
 }
 * }
 */
class TreeNode {
	public int val;
	public TreeNode left, right;
	public TreeNode(int val) {
	    this.val = val;
	    this.left = this.right = null;
	}
	
	@Override
	public String toString() {
		return ""+val;
	}
}
