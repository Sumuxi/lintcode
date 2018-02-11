package com.lintcode548;

/**548. 两数组的交 II
 * 挑战：What if the given array is already sorted? How would you optimize your algorithm?
 * 		What if nums1's size is small compared to num2's size? Which algorithm is better?
 * 		What if elements of nums2 are stored on disk, 
 * 		and the memory is limited such that you cannot load all elements into the memory at once?
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
	public int[] intersection(int[] nums1, int[] nums2) {
    	if(nums1.length==0)	return nums1;
        if(nums2.length==0)	return nums2;
        java.util.Arrays.sort(nums1);
    	java.util.Arrays.sort(nums2);
    	java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
        int i=0, j=0;
        while (i<nums1.length&&j<nums2.length) {
        	if(nums1[i]<nums2[j]){
				i++;
			}else if (nums1[i]>nums2[j]) {
				j++;
			}else {//nums1[i]==nums2[j]
				list.add(nums1[i++]);
				j++;
			}
		}
        int[] result = new int[list.size()];
        int k=0;
        for (Integer t : list) {
			result[k++] = t.intValue();
		}
        return result;
    }
    
}
