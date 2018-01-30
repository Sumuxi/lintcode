package com.lintcode071;

import java.util.List;

/**
 * 71. 二叉树的锯齿形层次遍历
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
	
    /**宽度优先搜索
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new java.util.ArrayList<List<Integer>>();
    	if (root == null) {
			return result;
		}
    	
        List<TreeNode> list1 = new java.util.ArrayList<TreeNode>();
        List<TreeNode> list2 = new java.util.ArrayList<TreeNode>();
    	list1.add(root);
    	boolean flag =true;//true代表正序
    	
    	while (list1.size()>0) {
    		List<Integer> list = new java.util.ArrayList<Integer>();
    		
    		for (int i=0; i<list1.size(); i++) {
				TreeNode t = list1.get(i);
				list.add(t.val);
				if (t.left!=null) {
					list2.add(t.left);
				}
        		if (t.right!=null) {
        			list2.add(t.right);
        		}
			}
    		if (flag) {
				flag  = false;
			}else {
				//将list逆转
		    	for (int i=0,j=list.size()-1; i<j; i++,j--) {
		    		Integer t = list.get(i);
		    		list.set(i, list.get(j));
		    		list.set(j, t);
				}
				flag = true;
			}
    		
        	result.add(list);
        	
        	//交换list1和list2
        	List<TreeNode> t = list1;
        	list1 = list2;
        	list2 = t;
        	list2.clear();
		}
    	
    	return result;
    }
    
    public int findPeak(int[] A) {
        // write your code here
    	//A.length >= 3
        for(int i=1,j=A.length-2; i<A.length-1&&j>0; i++,j--){
            if(A[i+1]<A[i])
                return i;
            if (A[j-1]<A[j]) {
				return j;
			}
        }
		return -1;//一定有峰值，所以这条语句没有作用，只是为了通过编译
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
