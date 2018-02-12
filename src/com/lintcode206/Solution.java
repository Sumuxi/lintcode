package com.lintcode206;

import java.util.List;

/**206. 区间求和 I
 * 挑战：O(logN) time for each query
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param A: An integer list
     * @param queries: An query list
     * @return: The result list
     */
    public List<Long> intervalSum(int[] arr, List<Interval> queries) {
    	//assert arr.length>0;
    	SegmentTreeNode root = buildTree(arr, 0, arr.length-1);
    	List<Long> result = new java.util.ArrayList<Long>();
    	for (int i=0; i<queries.size(); i++) {
    		result.add(query(root, queries.get(i)));
		}
    	return result;
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

	private long sum;
	
	private long query(SegmentTreeNode root, Interval interval) {
	    sum = 0;
		find(root, 0, interval.start, interval.end);
        return sum;
	}
    
    private void find(SegmentTreeNode node, long tempSum, int start, int end) {
		if(node==null||node.end<start||node.start>end){//node在查找区间之外
			return;
		}
    	if(node.start>=start&&node.end<=end){//node在查找区间之内
			tempSum+=node.sum;
    		sum+=tempSum;
			return;
		}
    	find(node.left, tempSum, start, end);
    	find(node.right, tempSum, start, end);
	}
	
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
