package com.lintcode048;

import java.util.List;

/**48. 主元素 III
 * 挑战：要求时间复杂度为O(n)，空间复杂度为O(k)
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        assert nums.size()>0;
    	java.util.HashMap<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();
        for (int i = 0; i < nums.size(); i++) {
			Integer key = nums.get(i);
        	if(map.containsKey(key)){
				map.put(key, map.get(key)+1);
			}else {
				map.put(key, 1);
			}
		}
        int n = nums.size()/k;
        java.util.Map.Entry<Integer, Integer> entry = null;
        for(java.util.Iterator<java.util.Map.Entry<Integer, Integer>> it 
        		= map.entrySet().iterator(); it.hasNext(); ) {
        	entry = it.next();
        	if(entry.getValue()>n){
        		break;
        	}
		}
        return entry.getKey();
    }
	
}
