package com.lintcode040;

/**40. 用栈实现队列 
 * 挑战：仅使用两个栈来实现它，不使用任何其他数据结构，push，pop 和 top的复杂度都应该是均摊O(1)的
 * 达到挑战要求
 * @author sumuxi
 *
 */
public class MyQueue {
	private java.util.Stack<Integer> head;//队列头,只能出栈
	private java.util.Stack<Integer> tail;//队列尾,只能进栈
	
    public MyQueue() {
        head = new java.util.Stack<Integer>();
        tail = new java.util.Stack<Integer>();
    }

    /**入队
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
    	tail.push(element);
    }

    /**出队
     * @return: An integer
     */
    public int pop() {
        if (head.isEmpty()) {
			if (tail.isEmpty()) throw new RuntimeException("the queue is null!");
			while (!tail.isEmpty()) {
				head.push(tail.pop());
			}
		}
        return head.pop();
    }

    /**获取队头元素
     * @return: An integer
     */
    public int top() {
    	if (head.isEmpty()) {
			if (tail.isEmpty()) throw new RuntimeException("the queue is null!");
			while (!tail.isEmpty()) {
				head.push(tail.pop());
			}
		}
        return head.peek();
    }
}