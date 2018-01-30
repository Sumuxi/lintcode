package com.lintcode099;

/**99. 重排链表
 * 挑战：必须在不改变节点值的情况下进行原地操作
 * @author sumuxi
 *
 */
public class Solution {
    
	/**这个方法会导致StackOverflowError
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList1(ListNode head) {
    	if(head==null)
    		return;
    	
    	ListNode p=head, q=head;
    	while(q!=null){
    		try {
    			q = q.next.next;
			} catch (NullPointerException e) {
				break;
			}
    		p = p.next;
    	}
    	ListNode r = p.next;
    	p.next = null;
    	
    	pnode = head;
    	push(r);
    }
    
    private ListNode pnode=null;
	private void push(ListNode r) {
		if(r==null)
			return;
		
		push(r.next);
		ListNode t=pnode.next;
		pnode.next = r;
		r.next = t;
		pnode = t;
	}
	
	public void reorderList(ListNode head) {
    	if(head==null)
    		return;
    	
    	ListNode p=head, q=head;
    	while(q!=null){
    		try {
    			q = q.next.next;
			} catch (NullPointerException e) {
				break;
			}
    		p = p.next;
    	}
    	ListNode r = p.next;
    	p.next = null;
    	
    	java.util.ArrayList<ListNode> list = new java.util.ArrayList<ListNode>();
    	while(r!=null){
    		list.add(r);
    		r = r.next;
    	}
    	int i = list.size()-1;
    	ListNode s = head;
    	while(i>=0){
    		ListNode t=s.next;
    		s.next = list.get(i--);
    		s.next.next = t;
    		s = t;
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