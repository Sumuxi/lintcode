package com.lintcode105;

/**105. 复制带随机指针的链表
 * 挑战：可否使用O(1)的空间
 * @author sumuxi
 *
 */
public class Solution {
	
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
	public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode result = null;
    	RandomListNode q = null;
    	RandomListNode p = head;
    	while(p!=null){
    		if(q ==null){
    			result = new RandomListNode(p.label);
    			q = result;
    		}else {
				q.next = new RandomListNode(p.label);
				q = q.next;
			}
    		p = p.next;
    	}
    	
    	p = head;
    	q = result;
    	while(p!=null){
    		if(p.random==null){
    			q.random=null;
    		}else {
    			RandomListNode t1 = head;
    			RandomListNode t2 = result;
    			while(t1!=p.random){
    				t1 = t1.next;
    				t2 = t2.next;
    			}
				q.random = t2;
			}
    		p = p.next;
    		q = q.next;
    	}
    	return result;
    }
    
}

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * }
 */
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}