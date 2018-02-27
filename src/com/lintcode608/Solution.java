package com.lintcode608;

/**608. 两数和-输入已排序的数组
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
	public int[] twoSum(int[] nums, int target) {
		assert nums.length>=2;//因为一定存在一组满足条件的结果
        int i=0;
        int j=nums.length-1;
        int sum;
        int[] result = new int[2];
        while(i<j){
        	sum = nums[i]+nums[j];
        	if(sum==target){
        		result[0] = i+1;
        		result[1] = j+1;
        		break;
        	}else if(sum<target) {
				i++;
			}else {//sum>target
				j--;
			}
        }
        return result;
    }
    
}
