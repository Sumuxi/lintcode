package com.lintcode511;

/**511. 交换链表当中两个节点
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**
	 * Definition for singly-linked list.
	 */
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	/**
     * @param head: a ListNode
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
	public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode s=new ListNode(0);
        s.next=head;
        ListNode t=s;
        ListNode p=null, q=null;
        while(t.next!=null){
        	if(t.next.val==v1){
        		p=t;
        	}else if (t.next.val==v2) {
				q=t;
			}
        	t=t.next;
        }
        //要特别注意 p.next==q or q.next==p 这两种情况
        if(p!=null&&q!=null&&p!=q){
        	if(p.next==q){
        		ListNode temp = p.next;
            	p.next = q.next;
            	q.next = q.next.next;
            	p.next.next = temp;
        	}else if(q.next==p){
        	    ListNode temp = q.next;
            	q.next = p.next;
            	p.next = p.next.next;
            	q.next.next = temp;
        	}else {
        		ListNode m = p.next;
            	p.next = m.next;
            	ListNode temp = q.next;
            	q.next = m;
            	m.next = temp;
            	q = q.next;
            	m = q.next;
            	q.next = m.next;
            	temp = p.next;
            	p.next = m;
            	m.next = temp;
			}
        }
        return s.next;
    }
    
}