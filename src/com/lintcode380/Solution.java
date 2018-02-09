package com.lintcode380;

/**380. 两个链表的交叉
 * 挑战：需满足 O(n) 时间复杂度，且仅用 O(1) 内存
 * @author sumuxi
 *
 */
public class Solution {
    
	/**这个方法实现了挑战
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1=0, n2=0, diff=0;
        ListNode head1 = headA, head2 = headB;
        while(head1!=null){
        	n1++;
        	head1 = head1.next;
        }
        while(head2!=null){
        	n2++;
        	head2 = head2.next;
        }
        if(n1<n2){
        	head1 = headB;
        	head2 = headA;
        	diff = n2-n1;
        }else {
        	head1 = headA;
        	head2 = headB;
        	diff = n1-n2;
		}
        for (int i = 0; i < diff; i++) {
			head1 = head1.next;
		}
        while(head1!=null&&head2!=null){
        	if(head1==head2)
        		return head1;
        	head1=head1.next;
        	head2=head2.next;
        }
        return null;
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