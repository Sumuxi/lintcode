package com.lintcode372;

/**372. 在O(1)时间复杂度删除链表节点
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**用当前结点的下一个结点来覆盖当前结点,
	 * 根据题意，不可能是删除尾结点，就不需要考虑删除尾结点的问题
	 * 其实真的删除尾结点的话，需要从头遍历到倒数第二个结点，删除尾结点即可
	 * 总体的时间复杂度还是O(1)
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
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