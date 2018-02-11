package com.lintcode632;

/**632. 二叉树的最大节点
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param root: the root of tree
     * @return: the max node
     */
    public TreeNode maxNode(TreeNode root) {
    	findMaxNode(root);
    	return result;
    }

    private TreeNode result=null;//成员变量，方法中可以直接操纵它
    
	private void findMaxNode(TreeNode node) {
		if(node==null)
			return;
		if(result==null)
			result = node;
		else {
			if(node.val>result.val)
				result=node;
		}
		findMaxNode(node.left);
		findMaxNode(node.right);
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