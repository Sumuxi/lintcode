package com.lintcode203;

/**203. 线段树的修改
 * 挑战：时间复杂度 O(h) , h 是线段树的高度
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param root: The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: 
     */
	public void modify(SegmentTreeNode node, int index, int value) {
        if(node.start==index&&node.end==index){
        	node.max = value;
        	return;
        }
        
        if(index>=node.start&&index<=node.end){
        	int mid = (node.start+node.end)/2;
        	if(index<=mid){
        		modify(node.left, index, value);
        	}else {
        		modify(node.right, index, value);
			}
        	node.max = node.left.max>node.right.max?node.left.max:node.right.max;
        }else {
			return;
		}
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