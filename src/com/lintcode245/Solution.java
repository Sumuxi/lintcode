package com.lintcode245;

/**245. 子树
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
 
	/**
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
	public boolean isSubtree(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2!=null)
            return false;
        if(t2==null)
        	return true;
    	if(isEqual(t1, t2)){
        	return true;
        }
        return (t1.left!=null&&isSubtree(t1.left, t2))||(t1.right!=null&&isSubtree(t1.right, t2));
    }

	private boolean isEqual(TreeNode t1, TreeNode t2) {
		if(t1==null&&t2==null)
			return true;
		if((t1==null&&t2!=null)||(t1!=null&&t2==null))
			return false;
		return t1.val==t2.val&&isEqual(t1.left, t2.left)&&isEqual(t1.right, t2.right);
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