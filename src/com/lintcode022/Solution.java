package com.lintcode022;

import java.util.List;
import java.util.Stack;

/**
 * 22. 平面列表
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

		System.out.println();
	}
	
	/**非递归方法实现
     * @param nestedList a list of NestedInteger
     * @return a list of integer
     */
	public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
		List<Integer> result = new java.util.ArrayList<Integer>();

    	Stack<List<NestedInteger>> stack = new Stack<List<NestedInteger>>();//保存当前的 nestedList
    	Stack<Integer> stack2 = new Stack<Integer>();//保存当前的索引 i
    	for (int i=0; i<nestedList.size(); i++) {
			NestedInteger n = nestedList.get(i);
    		if (n.isInteger()) {
				result.add(n.getInteger());
			} else {//n is a list
				stack.push(nestedList);
				stack2.push(i);
				nestedList = n.getList();
				i=-1;
			}
    		if (i==nestedList.size()-1) {
				while (!stack.empty() && (i=stack2.pop())==(nestedList=stack.pop()).size()-1) {

				}
			}
		}
    	
    	return result;
    }
	
    /**递归方法实现
     * @param nestedList a list of NestedInteger
     * @return a list of integer
     */
    public List<Integer> flatten1(List<NestedInteger> nestedList) {
        // Write your code here
    	List<Integer> list = new java.util.ArrayList<Integer>();
    	toList(list, nestedList);
    	return list;
    }

	private void toList(List<Integer> list, List<NestedInteger> nestedList) {
		for (NestedInteger n : nestedList) {
			if (n.isInteger()) {
				list.add(n.getInteger());
			}else {
				toList(list, n.getList());
			}
		}
	}

}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
interface NestedInteger {
	 
    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
