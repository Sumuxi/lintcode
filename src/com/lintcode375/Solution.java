package com.lintcode375;

import java.util.List;

/**375. 克隆二叉树
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param root: The root of binary tree
     * @return: root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        if(root==null)
        	return null;
        if(root.left==null&&root.right==null)//仅1个结点
        	return new TreeNode(root.val);
        TreeNode result = new TreeNode(root.val);//建立一个根结点
        cloneNode(root, result);
        return result;
    }

	private void cloneNode(TreeNode root, TreeNode result) {
		if(root.left!=null){
			result.left = new TreeNode(root.left.val);
			cloneNode(root.left, result.left);
		}
		if(root.right!=null){
			result.right = new TreeNode(root.right.val);
			cloneNode(root.right, result.right);
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