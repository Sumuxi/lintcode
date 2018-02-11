package com.lintcode633;

/**633. 寻找重复的数
 * 挑战：	1.不能修改数组(假设数组只能读)
 * 		2.只能用额外的O(1)的空间
 * 		3.时间复杂度小于O(n^2)
 * 		4.数组中只有一个重复的数，但可能重复超过一次
 * @author sumuxi
 *
 */
public class Solution {
	
	/**先排序再找到重复的数
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate1(int[] nums) {
        java.util.Arrays.sort(nums);
        int i=0;
        while(i<nums.length-1){
            if(nums[i]==nums[++i])
                break;
        }
        return nums[i];        
    }
    
    //如果仅有一个重复的数，且只重复一次，则下面的方法可行
    public int findDuplicate(int[] nums) {
        int sum=0;
    	int i=0;
        while(i<nums.length){
        	sum+=nums[i];
        }
        return sum-(nums.length-1)*nums.length/2;        
    }
    
}
