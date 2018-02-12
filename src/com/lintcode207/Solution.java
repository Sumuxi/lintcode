package com.lintcode207;

/**207. 区间求和 II
 * 挑战：O(logN) time for query and modify
 * @author sumuxi
 *
 */
public class Solution {
	
	/**定义线段树
	 * Definition of SegmentTreeNode:
	 * public class SegmentTreeNode {
	 *     public int start, end, max;
	 *     public SegmentTreeNode left, right;
	 *     public SegmentTreeNode(int start, int end, int max) {
	 *         this.start = start;
	 *         this.end = end;
	 *         this.max = max
	 *         this.left = this.right = null;
	 *     }
	 * }
	 */
	static class SegmentTreeNode {
        public int start, end;
        public long sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, long sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }
	
	private SegmentTreeNode root = null;

    /**构造函数，使用给定的数组建立线段树
     * @param A: An integer array
     */
    public Solution(int[] arr) {
    	if(arr.length>0){
    	    this.root = buildTree(arr, 0, arr.length-1);
    	}
    }
    
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
		node.sum = node.left.sum+node.right.sum;
		return node;
	}
    
    /**
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
    	sum = 0;
		find(root, start, end);
        return sum;
    }

    private long sum;
    
    private void find(SegmentTreeNode node, int start, int end) {
		if(node==null||node.end<start||node.start>end){//node在查找区间之外
			return;
		}
    	if(node.start>=start&&node.end<=end){//node在查找区间之内
    		sum+=node.sum;
			return;
		}
    	find(node.left, start, end);
    	find(node.right, start, end);
	}
    
    /**
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
    	modify(this.root, index, value);
    }
    
    private void modify(SegmentTreeNode node, int index, int value) {
        if(node.start==index&&node.end==index){
        	node.sum = value;
        	return;
        }
        
        if(index>=node.start&&index<=node.end){
        	int mid = (node.start+node.end)/2;
        	if(index<=mid){
        		modify(node.left, index, value);
        	}else {
        		modify(node.right, index, value);
			}
        	node.sum = node.left.sum+node.right.sum;
        }else {
			return;
		}
    }
	
}
