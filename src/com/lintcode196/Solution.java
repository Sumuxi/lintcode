package com.lintcode196;

/**196. 寻找缺失的数
 * 挑战：在数组上原地完成，使用O(1)的额外空间和O(N)的时间。
 * @author sumuxi
 *
 */
public class Solution {
  
	/**O(n)time,O(1)space
	 * 思路：题中给出一个包含 0 .. N 中 N 个数的序列，说明0~N中只有一个数没有出现，其他数均出现一次
	 * 那么计算序列的和，和真正的0~N但不缺的任何数序列的和比较,
	 * 两者的查即为缺失的那一个数
	 */
	public int findMissing(int[] nums) {
    	int sum=0;
		for (int i = 0; i < nums.length; i++) {
    		sum+=nums[i];
		}
    	//N=nums.length
    	return (nums.length+1)*nums.length/2 - sum;
    }
	
	/**桶排序的思想
     * @param nums: An array of integers
     * @return: An integer
     */
    public int findMissing1(int[] nums) {
    	for (int i = 0; i < nums.length; i++) {
    		/*当前桶中的数小于数组长度且桶中的数和序号不相等，一直循环直到不满足条件
    		 */
    		while (nums[i]<nums.length&&nums[i]!=nums[nums[i]]){
				int t = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = t;
			}
		}
    	
    	int i = 0;
    	while (i<nums.length&&nums[i]==i) {
			i++;
		}
    	return i;
    }
	
	/**189题.利用桶排序的思想
     * @param A: An array of integers
     * @return: An integer
     */
	public int firstMissingPositive(int[] A) {
    	for (int i = 0; i < A.length; i++) {
    		while (A[i]>0&&A[i]<A.length&&A[A[i]-1]!=A[i]){
				int t = A[A[i]-1];
				A[A[i]-1] = A[i];
				A[i] = t;
			}
		}
		int i = 0;
    	while (i<A.length) {
    		if(A[i]!=++i){
				return i;
			}
		}
    	return A.length+1;
    }
	
}
