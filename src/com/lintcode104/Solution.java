package com.lintcode104;

import java.util.List;

/**104. 合并k个排序链表
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(java.util.List<ListNode> lists) {  
        if(lists==null||lists.size()==0)
        	return null;
        
        ListNode result = new ListNode(0);
        ListNode p = result;
        while(lists.size()>0){
        	p.next = deleteMin(lists);
        	p = p.next;
        }
        return result.next;
    }

	private ListNode deleteMin(List<ListNode> lists) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		int i = 0;
		while(i<lists.size()){
			if(lists.get(i)==null){
				lists.remove(i);
			}else {
				if(lists.get(i).val<min){
					min = lists.get(i).val;
					index = i;
				}
				i++;
			}
		}
		try {
			ListNode t = lists.get(index);
			lists.set(index, lists.get(index).next);
			return t;
		} catch (IndexOutOfBoundsException e) {
			return null;
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
}