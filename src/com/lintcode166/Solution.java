package com.lintcode166;

/**166. 链表倒数第n个节点	
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**两根指针经典问题
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {
        ListNode p=head, q=head;
        int i = 0;
        while (i<n) {
			q = q.next;
        	i++;
		}
        while(q!=null){
        	p = p.next;
        	q = q.next;
        }
        return p;
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