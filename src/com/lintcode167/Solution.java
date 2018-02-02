package com.lintcode167;

/**167. 链表求和
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
	public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode result=null, s=null;
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
        	if(result==null){
        		result = new ListNode(sum);
        		s = result;
        	}else {
        		s.next = new ListNode(sum);
        		s = s.next;
			}
        }
        if(p>0){
            s.next = new ListNode(p);
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