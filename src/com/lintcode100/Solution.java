package com.lintcode100;

/**100. 删除排序数组中的重复数字
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
    	while(j<nums.length){
    		if(nums[j] == nums[i]){
    			j++;
    		}else {
				i++;
//				if(i<j)//可加，可不加
					nums[i] = nums[j];
				j++;
			}
    	}
    	return i+1;
    }
}
