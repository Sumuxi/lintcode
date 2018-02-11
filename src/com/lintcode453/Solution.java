package com.lintcode453;

/**453. 将二叉树拆成链
 * 挑战：不使用额外的空间耗费
 * @author sumuxi
 *
 */
public class Solution {
    
	/**迭代版本
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
	public void flatten1(TreeNode p) {
        while(p!=null){
        	if (p.left!=null) {
            	TreeNode t = p.left;
            	while (t.right!=null) {
            		t = t.right;
            	}
            	t.right = p.right;
            	p.right = p.left;
            	p.left = null;
    		}
        	p = p.right;
        }
    }
	
	//优化不好的递归版本
	public void flatten(TreeNode root) {
		if(root==null){
			return;
		}
		TreeNode p = root.right;
		if (root.left!=null) {
        	TreeNode t = root.left;
        	while (t.right!=null) {
        		t = t.right;
        	}
        	t.right = root.right;
        	root.right = root.left;
        	root.left = null;
        	flatten(root.right);
		}
		flatten(p);
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