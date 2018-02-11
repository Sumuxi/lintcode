package com.lintcode466;

/**466. 链表节点计数
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param head: the first node of linked list.
     * @return: An integer
     */
    public int countNodes(ListNode head) {
        int count=0;
        while (head!=null) {
			count++;
        	head = head.next;
		}
        return count;
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