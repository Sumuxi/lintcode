package com.lintcode223;

/**223. 回文链表
 * 挑战：O(n)的时间和O(1)的额外空间
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param head: A ListNode.
     * @return: A boolean.
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
        	return true;
        ListNode p=head, q=head;
        try {
        	while((q=q.next.next)!=null){//当条件不满足时，正常退出循环，此时链表元素为偶数个，p指向第n/2-1个结点(靠左的中间结点)
            	p=p.next;
            }
		} catch (NullPointerException e) {
			//当捕获到异常时，此时链表元素为奇数个，p指向中间结点
		}
        q=reverseList(p.next);
        p.next=null;
        p = head;
        while (q!=null) {
			if(q.val!=p.val)
				return false;
			q = q.next;
			p = p.next;
		}
        return true;
    }
    
    /*迭代版本，非递归
     */
    public ListNode reverseList(ListNode head) {
        ListNode result = null, next = null;
        while (head!=null) {
			next = head.next;
			head.next = result;
			result = head;
			head = next;
		}
        return result;
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