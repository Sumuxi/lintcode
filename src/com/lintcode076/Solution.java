package com.lintcode076;

/**76. 最长上升子序列
 * 挑战：要求时间复杂度为O(n^2) 或者 O(nlogn)
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestIncreasingSubsequence(
				new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
		
		
		int[] arr = s.LIS(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15});
		for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i]+" ");
		}
    	System.out.println();
		
	}
	
	/**O(n^2),对序列中的每个元素，统计它之前的最长上升序列长度，再加1即是当前的LIS长度
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        assert nums!=null;
    	if(nums.length<2){
    		return nums.length;
    	}
    	
    	int max = 0;
    	int[] array = new int[nums.length];
    	for (int i=0; i<nums.length; i++) {
    		int j=0;
			for (; j<i; j++) {
				if(nums[j]<nums[i]&&array[j]>array[i]){
					array[i] = array[j];
				}
			}
			array[i]++;//把自己算上
			if(array[i]>max){
				max = array[i];
			}
		}
    	
    	for (int i = 0; i < array.length; i++) {
    		System.out.print(array[i]+" ");
		}
    	System.out.println();
    	return max;
    }
	
    /**O(nlogn), 在Wikipedia上找到的牛B算法，每次将当前元素放入一个辅助数组，而且当前找到的LIS的最末元素是最小的
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int[] LIS(int[] nums) {
        assert nums!=null;
    	if(nums.length<2){
    		return nums;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
    	System.out.println();
    	int n = nums.length;
    	int[] p = new int[n];
    	int[] m = new int[n+1];
    	int l = 0;
    	for (int i = 0; i < n; i++) {
			int low = 1;
			int high = l;
			while (low<=high){
				int mid = (int) Math.ceil((low+high)/2);
				if(nums[m[mid]]<nums[i]){
					low = mid+1;
				}else {
					high = mid-1;
				}
			}
			p[i] = m[low-1];
			m[low] = i;
			if(low>l){
				l=low;
			}
			System.out.print("p"+i+": ");
			for (int j=0; j<=i; j++) {
	    		System.out.print(p[j]+" ");
			}
	    	System.out.println();
	    	System.out.print("m"+i+": ");
	    	for (int j=0; j<=l; j++) {
	    		System.out.print(m[j]+" ");
			}
	    	System.out.println();
	    	System.out.println();
		}
    	int[] s = new int[l];
    	int k = m[l];
    	for (int i = l-1; i>=0; i--) {
			s[i] = nums[k];
			k=p[k];
		}
    	for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
    	System.out.println();
    	return s;
    }
    
}
