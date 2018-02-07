package com.lintcode373;

/**373. 奇偶分割数组
 * 挑战：在原数组中完成，不使用额外空间。
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
    	int i = 0;
  		for (int j = 0; j < nums.length; j++) {
  			if((nums[j]&0x01)==1){
  				int t = nums[i];
  				nums[i++] = nums[j];
  				nums[j] = t;
  			}
  		}
    }
    
}
