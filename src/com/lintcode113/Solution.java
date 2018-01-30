package com.lintcode113;

/**113. 删除排序链表中的重复数字 II
 *  挑战：null
 * @author sumuxi
 *
 */
public class Solution {
    
	/**使用一个容器存储每个没有重复的结点，过滤掉有重复的结点
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
	public ListNode deleteDuplicates(ListNode head) {
    	if(head==null)
    		return head;
    	
    	ListNode p = head;
    	if(p.next==null)
    		return p;
    	java.util.ArrayList<ListNode> list = new java.util.ArrayList<ListNode>();
    	list.add(p);
    	p = p.next;
    	int i = 0;
    	boolean flag = false;
    	while(p!=null){
    		if(p.val == list.get(i).val){
    			flag = true;
    		}else {
				if(flag){
					list.set(i, p);
					if(i>0)
						list.get(i-1).next = p;
					flag = false;
				}else {
					list.get(i).next = p;
					list.add(p);
					i++;
				}
			}
    		
    		p = p.next;
    	}
    	if(flag){
    	    list.set(i, p);
			if(i>0)
				list.get(i-1).next = p;
		}else {
			list.get(i).next = p;
		}
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