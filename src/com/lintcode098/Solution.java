package com.lintcode098;

/**98. 链表排序 
 * 挑战：分别用归并排序和快速排序做一遍
 * @author sumuxi
 *
 */
public class Solution {

	/**这个方法在链表很长时会TLE, 所以, 链表排序的话，推荐使用归并排序
	 * 快速排序, quickSort, 思路就是先按照pivot划分链表为两个子链表，对子链表在进行快速排序
	 * 
	 * @param head:
	 *            The head of linked list.
	 * @return: You should return the head of the sorted linked list, using
	 *          constant space complexity.
	 */
	public ListNode sortList(ListNode head) {
		return quickSort(head, null);
	}

	private ListNode quickSort(ListNode head, ListNode end) {
		if (head == null || head.next == null)// 只有0或1个结点
			return head;
		ListNode p = head, q = head;
		while (q.next != end) {
			if (q.next.val <= head.val) {
				if(p!=q){
					ListNode t = p.next;
					p.next = q.next;
					q.next = q.next.next;
					p.next.next = t;
					p = p.next;
				}else {
					q = q.next;
					p = p.next;
				}
			} else {
				q = q.next;
			}
		}
		ListNode left = null;
		if(p!=head){//有左子链
			left = head.next;
			ListNode t = p.next;
			p.next = head;
			head.next = t;
			left = quickSort(left, head);
			head.next = quickSort(head.next, null);
			return left;
		}
		//没有左子链
		head.next = quickSort(head.next, null);
		return head;
	}

	/**
	 * 归并排序, mergeSort, 思路就是先分解成子问题，解决子问题，合并为解
	 * 
	 * @param head:
	 *            The head of linked list.
	 * @return: You should return the head of the sorted linked list, using
	 *          constant space complexity.
	 */
	public ListNode sortList1(ListNode head) {
		if (head == null || head.next == null)// 只有0或1个结点
			return head;
		ListNode p = head, q = head;
		try {
			while ((q = q.next.next) != null) {// 当条件不满足时，正常退出循环，此时链表元素为偶数个，p指向第n/2-1个结点(靠左的中间结点)
				p = p.next;
			}
		} catch (NullPointerException e) {
			// 当捕获到异常时，此时链表元素为奇数个，p指向中间结点
		}
		q = p.next;
		p.next = null;
		p = sortList1(head);
		q = sortList1(q);
		return mergeTwoLists(p, q);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode result;
		if (l1.val < l2.val) {
			result = l1;
			l1 = l1.next;
		} else {
			result = l2;
			l2 = l2.next;
		}
		ListNode p = result;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null) {
			p.next = l1;
		} else {
			p.next = l2;
		}
		return result;
	}

}

/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } }
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}
