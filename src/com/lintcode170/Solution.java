package com.lintcode170;

/**170. 旋转链表
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/** 链表问题，要特别注意空指针的判断和只有一个结点的链表
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
    		return head;
    	ListNode p=head, q=head;
        int i = 0;
        while (q!=null&&i<k) {
			q = q.next;
        	i++;
		}
        //此时一共有 i 个结点
        if(q==null){
        	int n = k%i;
        	int j = 0;
        	q = head;
            while (q!=null&&j<n) {
    			q = q.next;
            	j++;
    		}
        }
        while(q.next!=null){
        	p = p.next;
        	q = q.next;
        }
        ListNode result = p.next;
        p.next = null;
        p = result;
        if(p==null)//只有一个结点
            return head;
        while(p.next!=null){
        	p = p.next;
        }
        p.next = head;
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