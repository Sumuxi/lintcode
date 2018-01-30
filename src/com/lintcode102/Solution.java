package com.lintcode102;

/**102. 带环链表
 * 挑战：不要使用额外的空间
 * @author sumuxi
 *
 */
public class Solution {
    
	/**两根指针，快慢指针
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        if(head==null)
        	return false;
        ListNode p=head,q=head;
        while(q!=null){
        	try {
    			q = q.next.next;
			} catch (NullPointerException e) {//链表为偶数个数时会产生空指针异常
				break;
			}
    		p = p.next;
    		if(p==q)
    			return true;
        }
        return false;
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