package com.lintcode096;

/**96. 链表划分
 * 
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
	public ListNode partition(ListNode head, int x) {
        if(head==null)
        	return head;
        
        ListNode r = new ListNode(-1);
        r.next = head;
        ListNode p = r;
        while(p.next!=null&&p.next.val<x){
        	p = p.next;
        }
    	ListNode q = p;
    	while(q.next!=null){
        	if(q.next.val<x){
        		ListNode t1 = q.next;
        		q.next = q.next.next;
        		
        		ListNode t2 = p.next;
        		p.next = t1;
        		p = p.next;
        		p.next = t2;
        		
        	}else {
        		q = q.next;
			}
        }
        return r.next;
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
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
