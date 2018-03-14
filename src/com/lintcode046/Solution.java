package com.lintcode046;

import java.util.List;

/**46. 主元素
 * 挑战：要求时间复杂度为O(n)，空间复杂度为O(1)
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}
	
	/** 快排的划分方法，实现目标：时间复杂度为O(n)，空间复杂度为O(1)
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
    	assert nums!=null;
    	
    	int left = 0;
		int right = nums.size()-1;
		int i = partition(nums, left, right);
		int k = right>>>1;
		while (i!=k) {
			if(i>k){
				right = i-1;//减小右边界
				i = partition(nums, left, right);
			}else {//i<k
				left = i+1;//增大左边界
				i = partition(nums, left, right);
			}
		}
		return nums.get(k);
    }
    
	private int partition(List<Integer> nums, int left, int right) {
		Integer pivot = nums.get(right);
		int i = left;
		//把比枢纽大的值全放在左边
		for (int j=left; j<right; j++) {
			if(nums.get(j)>=pivot){
				Integer t = nums.get(i);
				nums.set(i++, nums.get(j));
				nums.set(j, t);
			}
		}
		nums.set(right, nums.get(i));
		nums.set(i, pivot);
		return i;
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
