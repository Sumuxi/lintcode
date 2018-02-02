package com.lintcode155;

/**155. 二叉树的最小深度
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {
    
	/**注意定义：二叉树的最小深度为根节点到最近叶子节点的距离。
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
    	if(root == null)
    		return 0;
    	
        getDepth(root, 1);
        return minDepth;
    }

    private int minDepth = Integer.MAX_VALUE;
	private void getDepth(TreeNode node, int d) {
		if(node.left==null&&node.right==null){
			if(d<minDepth)
				minDepth=d;
			return;
		}

		d++;
		if(d<minDepth){
		    if(node.left!=null)
			    getDepth(node.left, d);
			if(node.right!=null)
			    getDepth(node.right, d);
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