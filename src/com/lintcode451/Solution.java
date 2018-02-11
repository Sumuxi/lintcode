package com.lintcode451;

/**451. 两两交换链表中的节点
 * 挑战：你的算法只能使用常数的额外空间，并且不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param head: a ListNode
     * @return: a ListNode
     */
	public ListNode swapPairs(ListNode head) {
        ListNode result=null;
    	ListNode p=null, q=null, r=null;
        while (head!=null) {
        	p=head;
			q=p.next;
			if(q!=null){
				head = q.next;
				q.next=p;
				if(result==null){
					result = q;
					r = p;
				}else {
					r.next = q;
					r = p;
				}
			}else {
				break;
			}
		}
        if(q==null){//最后还有一个结点未处理
        	if(result==null){
				result = p;
			}else {
				r.next = p;
			}
        }else {
			r.next = null;
		}
        return result;
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