package com.lintcode247;

/**247. 线段树查询 II
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
    /**
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        this.total=0;
        find(root, start, end);
        return this.total;
    }

    private int total;
    
    private void find(SegmentTreeNode node, int start, int end) {
		if(node==null||node.end<start||node.start>end){//node在查找区间之外
			return;
		}
    	if(node.start>=start&&node.end<=end){//node在查找区间之内
			total+=node.count;
			return;
		}
    	find(node.left, start, end);//在左子树中查找
    	find(node.right, start, end);//在右子树中查找
	}
    
}
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
class SegmentTreeNode {
    public int start, end, count;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
        this.left = this.right = null;
    }
}