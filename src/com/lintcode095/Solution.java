package com.lintcode095;

/**95. 验证二叉查找树
 * 
 * @author sumuxi
 *
 */
public class Solution {
    
	public static void main(String[] args) {
		
	}

	/**对于二叉查找树中的非叶子结点，验证该结点的前驱以及后继是否满足要求
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST1(TreeNode root) {
        if(root==null)
        	return true;
        if(root.left==null&&root.right==null){
        	return true;
        }
        
        if(root.left!=null&&!isValidBST(root.left)){
        	return false;
        }
        if(root.left!=null){
        	TreeNode p = root.left;
        	while(p.right!=null){
        		p = p.right;
        	}
        	if(p.val>=root.val){
        		return false;
        	}
        }
        if(root.right!=null){
        	TreeNode p = root.right;
        	while(p.left!=null){
        		p = p.left;
        	}
        	if(p.val<=root.val){
        		return false;
        	}
        }
        if(root.right!=null&&!isValidBST(root.right)){
        	return false;
        }
        return true;
    }
    
    /**二叉查找树中序遍历会得到一个排序好的表,所以只要遍历中每一个元素大于它的前驱元素即可
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
    	if(root==null){
    		return true;
    	}
    	TreeNode t = null;
    	java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
        while (true) {
			if (root!=null) {
				stack.push(root);
				root = root.left;
			}else {
				if (stack.isEmpty()) {
					break;
				}else {
					root = stack.pop();
					if(t!=null&&t.val>=root.val)
						return false;
					t = root;
					root = root.right;
				}
			}
		}
        return true;
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
     
     @Override
     public java.lang.String toString() {
     	return (left!=null?left.toString():"")
     			+" "+this.val+" "+(right!=null?right.toString():"");
     }
 }