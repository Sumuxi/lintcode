package com.lintcode175;

import java.util.List;

/**175. 翻转二叉树
 * 挑战：递归固然可行，能否写个非递归的？
 * @author sumuxi
 *
 */
public class Solution {
    
	/**递归方法
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree1(TreeNode root) {
        invert(root);
    }

	private void invert(TreeNode node) {
		if(node==null){
			return;
		}
		TreeNode t = node.left;
		node.left = node.right;
		node.right = t;
		invert(node.left);
		invert(node.right);
	}
	
    //非递归方法, 使用一个队列
	public void invertBinaryTree(TreeNode root) {
		if(root==null) return;
		
		List<TreeNode> list1 = new java.util.ArrayList<TreeNode>();
	    List<TreeNode> list2 = new java.util.ArrayList<TreeNode>();
		list1.add(root);
		while (list1.size()>0) {
			for (TreeNode node : list1) {
				TreeNode t = node.left;
				node.left = node.right;
				node.right = t;
				if(node.left!=null)
					list2.add(node.left);
				if(node.right!=null)
					list2.add(node.right);
			}
			List<TreeNode> t = list1;
        	list1 = list2;
        	list2 = t;
        	list2.clear();
		}
    }
	
}
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
