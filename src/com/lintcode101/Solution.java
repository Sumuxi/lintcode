package com.lintcode101;

/**101. 删除排序数组中的重复数字 II
 *  挑战：null
 * @author sumuxi
 *
 */
public class Solution {
    
	/**两根指针
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
    	if(nums==null||nums.length==0)
    		return 0;

    	int i=0, j=1;
    	int count = 1;
    	while(j<nums.length){
    		if(nums[j]==nums[i]){
    			if(count<2){
    				nums[++i] = nums[j++];
        			count++;
    			}else {
					j++;
				}
    			
    		}else {
    			nums[++i] = nums[j++];
    			count = 1;
			}
    	}
    	return i+1;
    }
}
