package com.lintcode452;

/**452. 删除链表中的元素
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
	public ListNode removeElements(ListNode head, int val) {
        while (head!=null&&head.val==val) {
			head = head.next;
		}
        if(head==null)
        	return head;
        ListNode p = head;
        while (p.next!=null) {
			if(p.next.val==val)
        		p.next = p.next.next;
			else
				p = p.next;
		}
        return head;
    }
    
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
    	this.val = val;
    	this.next = null;
    }
}