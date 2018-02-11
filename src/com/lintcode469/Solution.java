package com.lintcode469;

/**469. 等价二叉树
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
    	if(a==null&&b==null)
			return true;
		if(a==null&&b!=null||a!=null&&b==null){
			return false;
		}
		if(a.val==b.val&&isIdentical(a.left, b.left)&&isIdentical(a.right, b.right)){
			return true;
		}
		return false;
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