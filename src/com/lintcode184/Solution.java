package com.lintcode184;

/**184. 最大数
 * 挑战：在 O(nlogn) 的时间复杂度内完成
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param nums: A list of non negative integers
     * @return: A string
     */
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++) {
			arr[i] = ""+nums[i];
		}
        java.util.Arrays.sort(arr, new java.util.Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
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
        	
        });
        
        if(arr[arr.length-1].equals("0"))//全部是0，只需返回 "0" 即可
        	return "0";

        StringBuilder sb = new StringBuilder();
        for (int j=arr.length-1; j>=0; j--) {
			sb.append(arr[j]);
		}
        return sb.toString();
    }
	
}
