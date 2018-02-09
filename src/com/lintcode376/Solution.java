package com.lintcode376;

import java.util.List;

/**376. 二叉树的路径和
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        if(root==null)
            return result;
    	List<Integer> list = new java.util.ArrayList<Integer>();
        traverlTree(list, root, target);
        return result;
    }

    List<List<Integer>> result = new java.util.ArrayList<List<Integer>>();;
    
	private void traverlTree(List<Integer> list, TreeNode node, int target) {
		list.add(node.val);
		if(node.left==null&&node.right==null){
			int sum=0;
			for (int i = 0; i < list.size(); i++) {
				sum+=list.get(i).intValue();
			}
			if(sum==target){
				List<Integer> temp = new java.util.ArrayList<Integer>();
				for (int i = 0; i < list.size(); i++) {
					temp.add(new Integer(list.get(i).intValue()));
				}
				result.add(temp);
			}
			return;
		}
		
		if(node.left!=null){
			traverlTree(list, node.left, target);
			list.remove(list.size()-1);
		}
		if(node.right!=null){
			traverlTree(list, node.right, target);
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