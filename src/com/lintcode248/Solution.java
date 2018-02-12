package com.lintcode248;

import java.util.List;

/**248. 统计比给定整数小的数的个数
 * 挑战：可否用一下三种方法完成以上题目。
 * 		1.仅用循环方法
 * 		2.分类搜索 和 二进制搜索
 * 		3.构建 线段树 和 搜索
 * @author sumuxi
 *
 */
public class Solution {
    
	/**简单循环方法
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] arr, int[] queries) {
    	List<Integer> result = new java.util.ArrayList<Integer>();
    	int count;
    	for (int i = 0; i < queries.length; i++) {
			count=0;
			for (int j = 0; j < arr.length; j++) {
				if(arr[j]<queries[i]){
					count++;
				}
			}
			result.add(count);
		}
    	return result;
    }
    
    /**构建 线段树 再 查询,这个方法居然超时
     */
    public List<Integer> countOfSmallerNumber1(int[] arr, int[] queries) {
    	if(arr.length>0){
    		root = buildTree(arr, 0, arr.length-1);
    	}
    	List<Integer> result = new java.util.ArrayList<Integer>();
    	for (int i = 0; i < queries.length; i++) {
			result.add(query(queries[i]));
		}
    	return result;
    }
    
    //定义线段树的结点类
    static class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }
    
    SegmentTreeNode root = null;
    
    /**二分法构造线段树
	 * @param arr
	 * @param p
	 * @param r
	 * @return 一棵线段树
	 */
	private SegmentTreeNode buildTree(int[] arr, int p, int r) {
		if(p==r){
			return new SegmentTreeNode(p, p, arr[p]);
		}
		//assert p<r;
		int q=(p+r)>>>1;
		SegmentTreeNode node = new SegmentTreeNode(p, r, 0);
		node.left = buildTree(arr, p, q);
		node.right = buildTree(arr, q+1, r);
		node.max = node.left.max>node.right.max?node.left.max:node.right.max;
		return node;
	}
	
	private int count;
	
	private int query(int value) {
		if(root==null){
			return 0;
		}
		count = 0;
		find(root, value);
        return count;
	}
    
    private void find(SegmentTreeNode node, int value) {
		if(node.max<value){
			count+=node.end-node.start+1;
			return;
		}
		if(node.left!=null)
			find(node.left, value);
		if(node.right!=null)
			find(node.right, value);
	}
    
}
