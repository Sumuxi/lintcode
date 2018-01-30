package com.lintcode088;

/**
 * 88. 最近公共祖先 挑战：null
 * 
 * @author sumuxi
 *
 */
public class Solution {

	/**
	 * @param root: The root of the binary search tree.
	 * @param A: A TreeNode in a Binary.
	 * @param B: A TreeNode in a Binary.
	 * @return: Return the least common ancestor(LCA) of the two nodes.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if(root==null)
			return root;
		java.util.ArrayList<TreeNode> list1 = new java.util.ArrayList<TreeNode>();
		java.util.ArrayList<TreeNode> list2 = new java.util.ArrayList<TreeNode>();
		find(list1, root, A);
		find(list2, root, B);
		int i=0;
		while(i<list1.size()&&i<list2.size()){
			if(list1.get(i) == list2.get(i))
				i++;
			else
				break;
		}
		return list1.get(i-1);
	}

	/**递归查找一个结点的所有父结点，存放到一个list中
	 * @param list
	 * @param p
	 * @param node
	 * @return
	 */
	private boolean find(java.util.ArrayList<TreeNode> list, TreeNode p, TreeNode node) {
		if(p==null){
			return false;
		}
		if(p==node){
			list.add(p);
			return true;
		}
		
		list.add(p);
		if(find(list, p.left, node))
			return true;
		if(find(list, p.right, node))
			return true;
		list.remove(list.size()-1);
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
