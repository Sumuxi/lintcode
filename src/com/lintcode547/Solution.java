package com.lintcode547;

/**547. 两数组的交
 * 挑战：可以用三种不同的方法实现吗？
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
	public int[] intersection1(int[] nums1, int[] nums2) {
    	if(nums1.length==0)	return nums1;
        if(nums2.length==0)	return nums2;
    	if(nums2.length<nums1.length){//确保nums1.length<=nums2.length
    		int[] t = nums1;
    		nums1 = nums2;
    		nums2 = t;
    	}
    	java.util.Arrays.sort(nums2);
    	java.util.HashSet<Integer> set = new java.util.HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
			if(java.util.Arrays.binarySearch(nums2, nums1[i])>=0)
				set.add(nums1[i]);
		}
        int[] result = new int[set.size()];
        int k=0;
        for (Integer i : set) {
			result[k++] = i.intValue();
		}
        return result;
    }
    
	public int[] intersection(int[] nums1, int[] nums2) {
    	if(nums1.length==0)	return nums1;
        if(nums2.length==0)	return nums2;
        java.util.Arrays.sort(nums1);
    	java.util.Arrays.sort(nums2);
    	java.util.HashSet<Integer> set = new java.util.HashSet<Integer>();
        int i=0, j=0;
        while (i<nums1.length&&j<nums2.length) {
        	if(nums1[i]<nums2[j]){
				i++;
			}else if (nums1[i]>nums2[j]) {
				j++;
			}else {//nums1[i]==nums2[j]
				set.add(nums1[i++]);
				j++;
			}
		}
        int[] result = new int[set.size()];
        int k=0;
        for (Integer t : set) {
			result[k++] = t.intValue();
		}
        return result;
    }
}
