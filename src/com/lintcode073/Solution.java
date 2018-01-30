package com.lintcode073;

import java.util.List;

/**73. 前序遍历和中序遍历树构造二叉树
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		System.out.println(new Solution().zigzagLevelOrder(root));
	}
	
	/**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	TreeNode root = null;
    	build(root,preorder,0,preorder.length,inorder,0,inorder.length);
    	return root;
    }

	private void build(TreeNode node,int[] pre,int s1,int len1,int[] in,int s2,int len2) {
		if(pre.length==1){
			node.left = new TreeNode(pre[0]);
		}
		
		node = new TreeNode(pre[s1]);//建立node
		
		//可以假设树中不存在相同数值的节点
		int t;
		for (int i = 0; i < in.length; i++) {
			if (in[i]==pre[s1]) {
				t = i;
				break;
			}
		}
		node.left = build(node.left, pre, s1+1, t-s2, in, s2, e2);
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
	public String toString() {
		return ""+val;
	}
}
