package com.lintcode174;

/**174. 删除链表中倒数第n个节点
 * 挑战：O(n)时间复杂度
 * @author sumuxi
 *
 */
public class Solution {
    
	/**两根指针，和找倒数第n个结点思路一样的
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode p=head, q=head;
    	int i=0;
    	//链表中的节点个数大于等于n
    	while(q!=null&&i<n){
    		q = q.next;
        	i++;
		}
    	if(q==null&&i==n){
    		return p.next;
    	}
        while(q.next!=null){
        	p = p.next;
        	q = q.next;
        }
        p.next = p.next.next;
        return head;
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