package com.lintcode112;

/**112. 删除排序链表中的重复元素
 *  挑战：null
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p!=null){
        	while(p.next!=null&&p.val==p.next.val){
        		p.next = p.next.next;
        	}
        	p = p.next;
        }
        return head;
    }
    
    //使用一个容器来存储每个元素一次，过滤掉重复元素
    public ListNode deleteDuplicates1(ListNode head) {
    	if(head==null)
    		return head;
    	
    	ListNode p = head;
    	java.util.ArrayList<ListNode> list = new java.util.ArrayList<ListNode>();
    	list.add(p);
    	p = p.next;
    	while (p!=null) {
			if(p.val != list.get(list.size()-1).val){
				list.get(list.size()-1).next = p;
				list.add(p);
			}
			p = p.next;
		}
		list.get(list.size()-1).next = p;
        return list.get(0);
    }
}

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}