package com.lintcode086;

/**86. 二叉查找树迭代器
 * 挑战：额外空间复杂度是O(h)，其中h是这棵树的高度, Super Star：使用O(1)的额外空间复杂度
 * @author sumuxi
 *
 */
public class BSTIterator {
    
	private java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
	
	/**
	 * @param root: The root of binary tree.
	 */
	public BSTIterator(TreeNode root) {
		while(root!=null){
			stack.push(root);
			root = root.left;
		}
    }

    /**
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return: return next node
     */
    public TreeNode next() {
    	TreeNode p = stack.pop();
    	TreeNode q = p.right;
    	while(q!=null){
			stack.push(q);
			q = q.left;
		}
    	return p;
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
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