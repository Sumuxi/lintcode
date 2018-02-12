package com.lintcode528;

import java.util.Iterator;
import java.util.List;

/**528. 摊平嵌套的列表
 * 挑战：
 * @author sumuxi
 *
 */
public class NestedIterator implements Iterator<Integer> {

	private List<Integer> list;
	private int index;
	
    public NestedIterator(List<NestedInteger> nestedList) {
    	list = new java.util.ArrayList<Integer>();
    	index = 0;
        toList(nestedList);
    }

    private void toList(List<NestedInteger> nestedList) {
    	for (NestedInteger t : nestedList) {
    		if(t.isInteger()){
    			list.add(t.getInteger());
    		}else {
    			toList(t.getList());
    		}
		}
	}

	// @return {int} the next element in the iteration
    @Override
    public Integer next() {
        return this.list.get(index++);
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        if(this.index<this.list.size())
        	return true;
        return false;
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */

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