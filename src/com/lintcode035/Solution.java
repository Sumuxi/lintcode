package com.lintcode035;

/**
 * 35. 翻转链表
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		new Solution().reverse(head);
		System.out.println(new Solution().reverse(head));
	}

	ListNode result = null;
	
	/**java的引用和函数传值很怪异,尤其是对于局部变量, 据说java函数传递的都是引用的副本
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
    	
    	reverseList(head);
    	return result;
    }

    private void reverseList(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode t = head.next;
		head.next = result;
		result = head;
		head = t;
		reverseList(head);
	}
    
    private void reverseList1(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode t = new ListNode(head.val);
		t.next = result;
		result = t;
		head = head.next;
		reverseList(head);
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
