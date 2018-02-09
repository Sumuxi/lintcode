package com.lintcode379;

/**379. 将数组重新排序以构造最小值
 * 挑战：在原数组上完成，不使用额外空间。
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param nums: n non-negative integer array
     * @return: A string
     */
    public String minNumber(int[] nums) {
    	quickSort(nums, 0, nums.length-1);
    	if(nums[nums.length-1]==0)//全部是0，只需返回 "0" 即可
        	return "0";
    	//一定有不为0的数,所以需要去掉前导0,
    	int i=0;
    	while (nums[i]==0) {
			i++;
		}
        StringBuilder sb = new StringBuilder();
        while (i<nums.length) {
			sb.append(nums[i++]);
		}
        return sb.toString();
    }
	
    private void quickSort(int[] nums, int start, int end) {
    	if(start>=end)
    		return;
		int i=start;
		String str = ""+nums[end];
		for (int j=start; j<end; j++) {
			if(compare(""+nums[j], str)<=0){
				int t = nums[i];
				nums[i++] = nums[j];
				nums[j] = t;
			}
		}
		int t = nums[i];
		nums[i] = nums[end];
		nums[end] = t;
		
		quickSort(nums, start, i-1);
		quickSort(nums, i+1, end);
	}

    private int compare(String s1, String s2) {
		for (int i=0,j=0; !(i==s1.length()&&j==s2.length()); i++,j++) {
			if(i==s1.length()){
				i--;
			}
			if(j==s2.length()){
				j--;
			}
			if(s1.charAt(i)<s2.charAt(j)){
				return -1;
			}else if (s1.charAt(i)>s2.charAt(j)) {
				return 1;
			}
		}
		return 0;
	}
}
