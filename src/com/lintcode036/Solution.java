package com.lintcode036;

/**
 * 36. 翻转链表 II
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
//		new Solution().reverse(head);
		System.out.println(new Solution().reverseBetween(head,4,5));
	}

	/**
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode r = head;//指向开始翻转结点的前一个结点
        ListNode p = head;//当前所指结点
        ListNode q = null;//临时保存结点
        ListNode tail = null;//临时结点的尾巴
    	
        int index = 1;
    	while (index<m) {
    		if (index==1) {
    			p = p.next;
			}else {
				p = p.next;
				r = r.next;
			}
			index++;
		}
    	tail = p;
    	while (index<=n) {
    		index++;
    		ListNode t = p.next;
    		p.next = q;
    		q = p;
    		p = t;
		}
    	tail.next = p;
    	if (m==1) {
			return q;
		}else {
			r.next = q;
			return head;
		}
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
    
    @Override
    public String toString() {
    	return val+"->"+(next==null?"null":next.toString());
    }
}
