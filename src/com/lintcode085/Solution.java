package com.lintcode085;

/**87. 删除二叉查找树的节点
 * 挑战：不使用递归
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
    	if(root==null)
    		return node;
    	TreeNode p = root, q = p;
    	while(p!=null){
    		q = p;
    		if(node.val>p.val){
    			p = p.right;
    		}else {
				p = p.left;
			}
    	}
    	if(node.val>q.val){
			q.right = node;
		}else {
			q.left = node;;
		}
    	return root;
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