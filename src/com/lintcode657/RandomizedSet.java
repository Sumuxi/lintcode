package com.lintcode657;

/**657. Insert Delete GetRandom O(1)
 * 挑战：
 * @author sumuxi
 *
 */
public class RandomizedSet {
	
	java.util.HashSet<Integer> set;
	
    public RandomizedSet() {
    	set = new java.util.HashSet<Integer>();
    }

    /**
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    /**
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /**
     * @return: Get a random element from the set
     */
    public int getRandom() {
        int index = (int)(Math.random()*set.size());
        return (int)set.toArray()[index];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */