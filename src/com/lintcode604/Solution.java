package com.lintcode604;

/**604. 滑动窗口内数的和
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**这里的窗口近似于队列
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
	public int[] winSum(int[] nums, int k) {
        if(k==0)
        	return new int[0];
        assert k>0&&nums.length>=k;
    	int[] result = new int[nums.length-k+1];
    	for (int i = 0; i < k; i++) {
    		result[0]+=nums[i];
		}
    	int j=0;
    	for (int i = k; i < nums.length; i++) {
			result[j+1] = result[j++] + nums[i] - nums[i-k];//加入队元素减出队元素
		}
    	return result;
    }
    
}
