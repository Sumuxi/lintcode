package com.lintcode636;

/**636. 132 模式
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
	
	/**循环法，TLE
     * @param nums: a list of n integers
     * @return: true if there is a 132 pattern or false
     */
	public boolean find132pattern(int[] nums) {
        if(nums.length<3)
        	return false;
        for (int j=1; j<nums.length-1; j++) {
			int k=j+1;
			while (k<nums.length) {
				if(nums[k]<nums[j]){
                    int i=j-1;
					while (i>=0) {
						if(nums[i]<nums[k]){
							return true;
						}
						i--;
					}
				}
				k++;
			}
		}
        return false;
    }
    
}
