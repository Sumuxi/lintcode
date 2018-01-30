package com.lintcode070;

import java.util.List;

/**
 * 70. 二叉树的层次遍历 II
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(3);
//		root.right = new TreeNode(4);
//		root.right.left = new TreeNode(5);
		System.out.println(new Solution().levelOrderBottom(root));
	}
	
	//挑战1：只使用一个队列去实现它
	//挑战2：用DFS算法来做
    /**宽度优先搜索
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
    	
    	//将result逆转
    	for (int i=0,j=result.size()-1; i<j; i++,j--) {
    		List<Integer> t = result.get(i);
    		result.set(i, result.get(j));
    		result.set(j, t);
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
