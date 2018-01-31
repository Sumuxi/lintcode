package com.lintcode148;

/**148. 颜色分类 
 * 挑战：一个相当直接的解决方案是使用计数排序扫描2遍的算法。
 * 首先，迭代数组计算 0,1,2 出现的次数，然后依次用 0,1,2 出现的次数去覆盖数组。
 * 你否能想出一个仅使用常数级额外空间复杂度且只扫描遍历一遍数组的算法？
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
	public void sortColors(int[] nums) {
        if(nums==null||nums.length<=1)
            return;
        
        int index0 = 0, index2 = nums.length-1;
        
        int i = 0;
        while(i<=index2){
        	if(nums[i]==0){
        		if(i>index0){
        			int t = nums[index0];
    				nums[index0++] = nums[i];
    				nums[i] = t;
        		}else{
        			i++;
        			index0++;
        		}
				continue;
			}
			if(nums[i]==2){
				if(i<index2){
					int t = nums[index2];
					nums[index2--] = nums[i];
					nums[i] = t;
				}else{
					i++;
					index2--;
				}
				continue;
			}
			//nums[i]==1
			i++;
        }
    }

    
}
