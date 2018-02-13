package com.lintcode450;

/**450. K组翻转链表
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<2)
        	return head;
        ListNode result = new ListNode(0);
        ListNode r = result;
        ListNode phead, ptail;
        while (head!=null) {
        	//截取k个结点
        	phead = head;
        	int i=1;
            while(i<k&&head.next!=null){
            	head=head.next;
            	i++;
            }
            if(i<k){//没有k个结点
            	r.next = phead;
            	break;
            }
            ptail = head;
            head = head.next;
            ptail.next=null;//k个结点的尾指针置空，便于循环结束
            //翻转phead->...->ptail
            ListNode t1 = null;
            ListNode q = phead;
            while (q!=null) {
            	ListNode t2=q;
            	q=q.next;
            	t2.next=t1;
            	t1 = t2;
    		}
            r.next = ptail;
            r = phead;
            r.next = null;//向结果链表的尾巴添加k个结点，并把第k个结点的尾指针置空
		}
        return result.next;
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