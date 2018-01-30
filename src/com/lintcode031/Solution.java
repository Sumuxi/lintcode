package com.lintcode031;

/**
 * 31. 数组划分
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

		System.out.println(new Solution().partitionArray(new int[]{3,2,2,1}, 2) );
	}

	/**快排的思想
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums.length==0) {
			return 0;
		}
    	int i = 0;
    	int j = nums.length-1;
    	
    	while (i<j) {
    		while (i<=j&&nums[i]<k) {//只能是 <=, 因为返回 i, 考虑所有数都小于k的情况
    			i++;
    		}
        	while (j>i&&nums[j]>=k) {//可以 =， 也可以是 >=
    			j--;
    		}
        	if (i<j) {
        		int temp=nums[i];
        		nums[i] = nums[j];
        		nums[j] = temp;
        		i++;
        	    j--;
			}else {
				break;
			}
		}
    	
    	return i;
    }
}
