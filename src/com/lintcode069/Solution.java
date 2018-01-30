package com.lintcode069;

import java.util.List;

/**
 * 69. 二叉树的层次遍历
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
		System.out.println(new Solution().levelOrder1(root));
	}
	
	//挑战1：只使用一个队列去实现它
	//挑战2：用DFS算法来做
	/**使用一个队列实现
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new java.util.ArrayList<List<Integer>>();
    	if (root == null) {
			return result;
		}
    	
        List<TreeNode> queue = new java.util.ArrayList<TreeNode>();
    	queue.add(root);
    	int index = 0;
    	int size;
    	while (index<queue.size()) {
    		size = queue.size();
    		List<Integer> list = new java.util.ArrayList<Integer>();
        	while (index<size) {
        		TreeNode t=queue.get(index++);
        		list.add(t.val);
        		if (t.left!=null) {
					queue.add(t.left);
				}
        		if (t.right!=null) {
        			queue.add(t.right);
        		}
    		}
        	result.add(list);
		}
    	return result;
    }
    
    /**广度优先搜索
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
    	List<List<Integer>> result = new java.util.ArrayList<List<Integer>>();
    	if (root == null) {
			return result;
		}
    	
        List<TreeNode> list1 = new java.util.ArrayList<TreeNode>();
        List<TreeNode> list2 = new java.util.ArrayList<TreeNode>();
    	list1.add(root);
    	
    	while (list1.size()>0) {
    		List<Integer> list = new java.util.ArrayList<Integer>();
    		for (TreeNode t : list1) {
				list.add(t.val);
				if (t.left!=null) {
					list2.add(t.left);
				}
        		if (t.right!=null) {
        			list2.add(t.right);
        		}
			}
        	result.add(list);
        	
        	List<TreeNode> t = list1;
        	list1 = list2;
        	list2 = t;
        	list2.clear();
		}
    	return result;
    }

}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 public int val;
 public TreeNode left, right;
 public TreeNode(int val) {
     this.val = val;
     this.left = this.right = null;
 }
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
