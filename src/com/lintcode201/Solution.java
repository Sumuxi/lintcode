package com.lintcode201;

/**201. 线段树的构造
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
	public SegmentTreeNode build(int start, int end) {
        if(start>end)
            return null;
    	if(start==end){
        	return new SegmentTreeNode(start, end);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        int mid = (start+end)/2;
        root.left = build(start, mid);
        root.right = build(mid+1, end);
        return root;
    }
    
}
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */
class SegmentTreeNode {
    public int start, end;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }
}