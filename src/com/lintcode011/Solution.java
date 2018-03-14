package com.lintcode011;

import java.util.List;

/**11. 二叉查找树中搜索区间,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(8);
		
		Solution s = new Solution();
		System.out.println(s.searchRange(root, 1, 8));
	}
	
	/*BST中序遍历的结果是升序排序的，这里可以在中序遍历的同时判断值是否在区间内
		 */
	
	List<Integer> result = new java.util.ArrayList<Integer>();
	
	/**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        if(root==null)
        	return result;
        
    	if(root.val<k1){
    		searchRange(root.right, k1, k2);
    	}else if (root.val>k2) {
			searchRange(root.left, k1, k2);
		}else{
			searchRange(root.left, k1, k2);
			result.add(root.val);
			searchRange(root.right, k1, k2);
		}
    	return result;
    }
	
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange1(TreeNode root, int k1, int k2) {
        // write your code here
    	java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
    	search(list, root, k1, k2);
    	java.util.Collections.sort(list);//quicksort
    	return list;
    }

	private void search(java.util.ArrayList<Integer> list, TreeNode node, int k1, int k2) {
		if (node==null) {
			return;
		}
		if (node.val>=k1&&node.val<=k2) {
			list.add(node.val);
		}
		search(list, node.left, k1, k2);
		search(list, node.right, k1, k2);
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
