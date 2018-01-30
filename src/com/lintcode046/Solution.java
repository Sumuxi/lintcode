package com.lintcode046;

import java.util.List;

/**
 * 46. 主元素
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}
	
	/** 实现目标：时间复杂度为O(n)，空间复杂度为O(1)
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
    	//认为nums非空
    	java.util.HashMap<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();
    	return -1;
    }

	/**没有实现时间复杂度为O(n)，空间复杂度为O(1)的要求
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber1(List<Integer> nums) {
        // write your code here
    	//认为nums非空
    	java.util.HashMap<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();
    	for (Integer i : nums) {
			if (map.containsKey(i)) {//已经有了
				map.put(i, map.get(i)+1);
			}else {//第一次出现
				map.put(i, 1);
			}
		}

    	int max = -1;
    	int key = 0;
    	for (java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue()>max) {
				max = entry.getValue();
				key = entry.getKey();
			}
		}
    	return key;
    }
	
}
