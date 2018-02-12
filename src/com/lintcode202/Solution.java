package com.lintcode202;

/**202. 线段树的查询
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
    	max = Integer.MIN_VALUE;
        findMax(root, start, end);
        return max;
    }
    
    private int max;
    
    private void findMax(SegmentTreeNode node, int start, int end) {
		if(node==null||node.end<start||node.start>end){//node在查找区间之外
			return;
		}
    	if(node.start>=start&&node.end<=end){//node在查找区间之内
			if(node.max>max)
				max = node.max;
			return;
		}
    	findMax(node.left, start, end);//在左子树中查找
    	findMax(node.right, start, end);//在右子树中查找
	}
    
}
/**
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