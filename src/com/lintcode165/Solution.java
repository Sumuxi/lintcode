package com.lintcode165;

/**165. 合并两个排序链表
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1==null)	return l2;
    	if(l2==null)	return l1;
    	
    	ListNode result = new ListNode(0);
    	ListNode p = result;
    	while(l1!=null&&l2!=null){
    		if(l1.val<l2.val){
    			p.next = l1;
    			l1 = l1.next;
    		}else {
				p.next = l2;
				l2 = l2.next;
			}
    		p = p.next;
    	}
    	if(l1!=null){
    		p.next = l1;
    	}else {
			p.next = l2;
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