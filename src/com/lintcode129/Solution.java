package com.lintcode129;

/**129. 重哈希
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {
	
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
	public ListNode[] rehashing(ListNode[] hashTable) {
        if(hashTable==null||hashTable.length==0)//这种判断貌似很费时间，而且起的作用不大
        	return null;
        
        int len = hashTable.length*2;
        ListNode[] result = new ListNode[len];
        for (int i = 0; i < hashTable.length; i++) {
        	while(hashTable[i]!=null){
				ListNode t = hashTable[i];
				hashTable[i] = hashTable[i].next;
				t.next = null;
				int index = (t.val%len+len)%len;
				if(result[index]==null){
					result[index] = t;
				}else {
					ListNode p = result[index];
					while(p.next!=null)
						p = p.next;
					p.next = t;
				}
			}
		}
        return result;
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