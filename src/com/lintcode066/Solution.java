package com.lintcode066;

import java.util.List;

/**
 * 66. 二叉树的前序遍历
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		System.out.println(new Solution().preorderTraversal(root));
	}
	
	/**非递归方法实现，比递归实现要慢
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
        List<Integer> result = new java.util.ArrayList<Integer>();
        while (true) {
			if (root!=null) {
				result.add(root.val);
				stack.push(root);
				root = root.left;
			}else {
				if (stack.isEmpty()) {
					break;
				}else {
					root = stack.pop().right;
				}
			}
		}
        return result;
    }
    
    
	
	/**递归方法实现,根据评测结果，递归实现比非递归实现要快一些
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        // write your code here
        List<Integer> result = new java.util.ArrayList<Integer>();
        travelTree(result, root);
        return result;
    }

	private void travelTree(List<Integer> result, TreeNode node) {
		if (node==null) {
			return;
		}
		result.add(node.val);
		travelTree(result, node.left);
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
