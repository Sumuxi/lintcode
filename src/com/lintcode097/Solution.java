package com.lintcode097;

/**97. 二叉树的最大深度
 * 
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
	private int max = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        int depth = 0;
        getDepth(root, depth);
        return max;
    }

	private void getDepth(TreeNode node, int depth) {
		if(node==null){
			if(depth>max)
				max = depth;
			return;
		}
			
		depth++;
		getDepth(node.left, depth);
		getDepth(node.right, depth);
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