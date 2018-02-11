package com.lintcode480;

import java.util.List;

/**
 * 480. 二叉树的所有路径 挑战：
 * 
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
	 * @param root: the root of the binary tree
	 * @return: all root-to-leaf paths
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new java.util.ArrayList<String>();
		List<Integer> list = new java.util.ArrayList<Integer>();
		travelTree(result, list, root);
		return result;
	}

	private void travelTree(List<String> result, List<Integer> list, TreeNode node) {
		if(node==null)
			return;
		list.add(node.val);
		if(node.left==null&&node.right==null){//到达叶子节点
			StringBuilder sb = new StringBuilder();
			int i = 0;
			while(i<list.size()-1) {
				sb.append(list.get(i++)+"->");
			}
			sb.append(list.get(i));
			result.add(sb.toString());
			return;
		}
		if(node.left!=null){
			travelTree(result, list, node.left);
			list.remove(list.size()-1);
		}
		if(node.right!=null){
			travelTree(result, list, node.right);
			list.remove(list.size()-1);
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