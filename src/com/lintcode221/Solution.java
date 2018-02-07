package com.lintcode221;

/**221. 链表求和 II
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
    	l1 = reverseList(l1);
    	l2 = reverseList(l2);
    	ListNode result=null;
        int p = 0;//低位向本位的进位
        int sum;//本位和
        while(l1!=null||l2!=null){
        	sum = p;
        	if(l1!=null){
        		sum += l1.val;
        		l1 = l1.next;        		
        	}
        	if(l2!=null){
        		sum += l2.val;
        		l2 = l2.next;        		
        	}
        	if(sum>=10){
        		sum -= 10;
        		p = 1;
        	}else {
				p = 0;
			}
        	
        	ListNode t = result;
        	result = new ListNode(sum);
        	result.next = t;
        }
        if(p>0){
        	ListNode t = result;
        	result = new ListNode(p);
        	result.next = t;
        }
        return result;
    }
    
    /*迭代版本，非递归
     */
    public ListNode reverseList(ListNode head) {
        ListNode result = null, next = null;
        while (head!=null) {
			next = head.next;
			head.next = result;
			result = head;
			head = next;
		}
        return result;
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