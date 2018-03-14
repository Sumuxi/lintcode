package com.lintcode106;

/**106. 排序列表转换为二分查找树
 * 
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode node) {
    	if(node==null)
			return null;
		if(node.next==null){
			return new TreeNode(node.val);
		}
		
		ListNode p=node, q=node, r=p;
    	while(q!=null){
    		try{
        		q=q.next.next;
        	}catch (NullPointerException e) {
    			break;
    		}
    		r=p;
    		p=p.next;
    	}
		TreeNode tnode = new TreeNode(p.val);
		r.next=null;
		tnode.left = sortedListToBST(node);
		tnode.right = sortedListToBST(p.next);
		return tnode;
    }

}
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}