package com.lintcode539;

/**539. 移动零
 * 挑战：原地操作，最小化操作数
 * @author sumuxi
 *
 */
public class Solution {
	
	/**两根指针
     * @param nums: an integer array
     * @return: 
     */
    public void moveZeroes(int[] nums) {
        int i=0;
        while(i<nums.length&&nums[i]!=0){
        	i++;
        }
        int j=i+1;
        while (j<nums.length) {
			if(nums[j]!=0){
				nums[i++]=nums[j];
			}
			j++;
		}
        while(i<nums.length){
        	nums[i++]=0;
        }
    }
    
}
