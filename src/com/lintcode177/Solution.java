package com.lintcode177;

/**177. 把排序数组转换为高度最小的二叉搜索树
 * 
 * @author sumuxi
 *
 */
public class Solution {
	
    /**二分法，递归
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
    	if(A==null||A.length==0)
    		return null;
    	
    	int left=0, right=A.length-1;
    	return toBST(A, left, right);
    }
    
    private TreeNode toBST(int[] arr, int left, int right) {
    	if(left>right)
    		return null;
    	if(left==right){
    		return new TreeNode(arr[left]);
    	}
		
    	int mid = (left+right)>>>1;
    	TreeNode node = new TreeNode(arr[mid]);
    	node.left = toBST(arr, left, mid-1);
    	node.right = toBST(arr, mid+1, right);
		return node;
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