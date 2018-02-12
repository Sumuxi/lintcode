package com.lintcode205;

import java.util.List;

/**205. 区间最小数
 * 挑战：每次查询在O(logN)的时间内完成
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param A: An integer array
     * @param queries: An query list
     * @return: The result list
     */
    public List<Integer> intervalMinNumber(int[] arr, List<Interval> queries) {
    	//arr.length>0
    	//二分法构造线段树
    	SegmentTreeNode root = buildTree(arr, 0, arr.length-1);
    	List<Integer> result = new java.util.ArrayList<Integer>();
    	for (int i=0; i<queries.size(); i++) {
    		result.add(query(root, queries.get(i)));
		}
    	return result;
    }
    
	private SegmentTreeNode buildTree(int[] arr, int p, int r) {
		if(p==r){
			return new SegmentTreeNode(p, p, arr[p]);
		}
		//p<r
		int q=(p+r)>>>1;
		SegmentTreeNode node = new SegmentTreeNode(p, r, 0);
		node.left = buildTree(arr, p, q);
		node.right = buildTree(arr, q+1, r);
		node.min = node.left.min<node.right.min?node.left.min:node.right.min;
		return node;
	}

	private int min;
	
	private Integer query(SegmentTreeNode root, Interval interval) {
	    min = Integer.MAX_VALUE;
		findMin(root, interval.start, interval.end);
        return min;
	}
    
    private void findMin(SegmentTreeNode node, int start, int end) {
		if(node==null||node.end<start||node.start>end){//node在查找区间之外
			return;
		}
    	if(node.start>=start&&node.end<=end){//node在查找区间之内
			if(node.min<min)
				min = node.min;
			return;
		}
    	findMin(node.left, start, end);
    	findMin(node.right, start, end);
	}
	
    static class SegmentTreeNode {
        public int start, end, min;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
            this.left = this.right = null;
        }
    }
    
}

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
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
