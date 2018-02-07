package com.lintcode173;

/**173. 链表插入排序
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
    	ListNode result = new ListNode(0);
    	ListNode p;
    	while(head!=null){
    		p = result;
    		while(p.next!=null&&head.val>=p.next.val){
    			p = p.next;
    		}
    		if(p==result){
    			ListNode t1 = head;
    			head = head.next;
    			ListNode t2 = result.next;
    			result.next = t1;
    			t1.next = t2;
    		}else {
    			ListNode t1 = head;
    			head = head.next;
    			ListNode t2 = p.next;
    			p.next = t1;
    			t1.next = t2;
    		}
    	}
    	return result.next;
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