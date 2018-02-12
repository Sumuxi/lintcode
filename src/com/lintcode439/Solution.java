package com.lintcode439;

/**439. 线段树的构造 II
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
    class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }
    
    /**
     * @param A: a list of integer
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] arr) {
    	if(arr.length>0){
    	    this.root = buildTree(arr, 0, arr.length-1);
    	}
    	return this.root;
    }
    
    private SegmentTreeNode root = null;
    
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
	
}
