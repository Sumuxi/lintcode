package com.lintcode103;

/**103. 带环链表 II
 * 挑战：不要使用额外的空间
 * @author sumuxi
 *
 */
public class Solution {
    
	/**快慢指针, Floyd环判定算法
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
    	if(head==null)
        	return head;
        ListNode p=head,q=head;//慢、快指针
        boolean flag = false;//是否存在环
        while(q!=null){
        	try {
    			q = q.next.next;
			} catch (NullPointerException e) {//链表为偶数个数时会产生空指针异常
				break;
			}
    		p = p.next;
    		if(p==q){
    			flag = true;
    			break;
    		}
        }
        if(flag){
        	p = head;
        	while(p!=q){//一定在环开始结点相遇
        		p = p.next;
        		q = q.next;
        	}
        	return p;
        }
        return null;
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