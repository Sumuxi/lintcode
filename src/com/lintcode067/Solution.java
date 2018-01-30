package com.lintcode067;

import java.util.List;

/**
 * 67. 二叉树的中序遍历
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		System.out.println(new Solution().inorderTraversal(root));
	}
	
	/**非递归方法实现，比递归实现要慢
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
        List<Integer> result = new java.util.ArrayList<Integer>();
        while (true) {
			if (root!=null) {
				stack.push(root);
				root = root.left;
			}else {
				if (stack.isEmpty()) {
					break;
				}else {
					root = stack.pop();
					result.add(root.val);
					root = root.right;
				}
			}
		}
        return result;
    }
    
    
	
	/**递归方法实现
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
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
		travelTree(result, node.left);
		result.add(node.val);
		travelTree(result, node.right);
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
