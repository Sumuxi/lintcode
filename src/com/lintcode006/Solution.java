package com.lintcode006;

/** 5. 第k大元素 ,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4};//A=[1,2,3,4]，B=[2,4,5,6]
		int[] b = new int[]{2,4,5,6};
		int[] nums = mergeSortedArray(a, b);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}
	
    /** 我写的二路归并排序
     * @param A sorted integer array A
     * @param B sorted integer array B
     * @return a new sorted integer array
     */
    public static int[] mergeSortedArray1(int[] A, int[] B) {//二路归并排序
        // write your code here
    	int[] arr = new int[A.length+B.length];
    	
    	int i=0,j=0;
    	int index = 0;
    	while (i<A.length||j<B.length) {
			while (i<A.length&&j!=B.length&&A[i]<=B[j]) {
				arr[index++]=A[i++];
			}
			while (i!=A.length&&j<B.length&&A[i]>B[j]) {
				arr[index++]=B[j++];
			}
			if (i==A.length||j==B.length) {
				while (i<A.length) {
					arr[index++]=A[i++];
				}
				while (j<B.length) {
					arr[index++]=B[j++];
				}
			}
		}
    	
    	return arr;
    }
    
    /** 标准的二路归并排序
     * @param A sorted integer array A
     * @param B sorted integer array B
     * @return a new sorted integer array
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {
    	// write your code here
    	int[] arr = new int[A.length+B.length];
    	
    	int i=0,j=0;
    	int index = 0;
    	while (i<A.length&&j<B.length) {
    		if (A[i]<=B[j]) {
				arr[index++] = A[i++];
			}else {
				arr[index++] = B[j++];
			}
    	}
    	
    	while (i<A.length) {
			arr[index++]=A[i++];
		}
		while (j<B.length) {
			arr[index++]=B[j++];
		}
    	
    	return arr;
    }
}
