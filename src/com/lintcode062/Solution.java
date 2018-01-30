package com.lintcode062;

/**62. 搜索旋转排序数组
 * 挑战：O(logN) time
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
//		System.out.println(java.util.Arrays.binarySearch(new int[]{1,2,3}, 2, 3, 3));
		System.out.println(new Solution().search2(new int[]{4,5,6,1,2,3}, 1));
		
	}
	
	/**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
	public int search(int[] A, int target) {
    	if(A==null||A.length==0)
     	   return -1;

    	int start=0;
        int end = A.length - 1;
        int mid = 0;
        
        while (start<=end) {
			mid = (start+end)/2;
			if(A[mid]>=A[0]){
				start= mid+1;
			}else {
				end = mid-1;
			}
		}
        System.out.println(start);
        //start指向第一次出现的小数的索引或者A.length
        
        int temp = -1;
        if(target>=A[0])
			temp = java.util.Arrays.binarySearch(A, 0, start, target);
        else if(target<=A[A.length-1])
			temp = java.util.Arrays.binarySearch(A, start, A.length, target);
        
        return temp<0?-1:temp;
    }
	
	/**二分查找的思想，AC
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search1(int[] A, int target) {
    	if(A==null||A.length==0)
     	   return -1;

    	int start=0;
        int end = A.length - 1;
        int mid = 0;
        
        if(target>=A[0]){//在前半段
        	while (start<=end) {
    			mid = (start+end)/2;
    			if (A[mid]<A[0]) {
					end = mid-1;
				}else if(target<A[mid]){
    				end= mid-1;
    			}else if (A[mid]>=A[0]&&target>A[mid]) {
					start = mid+1;
				}else if(target==A[mid]){//target==A[mid]
    				return mid;
    			}
    		}
        	
        }else if(target<=A[A.length - 1]){//在后半段
        	while (start<=end) {
    			mid = (start+end)/2;
    			if (A[mid]>A[A.length - 1]) {
					start = mid+1;
				}else if(target>A[mid]){
    				start= mid+1;
    			}else if (A[mid]<=A[A.length - 1]&&target<A[mid]) {
					end = mid-1;
				}else if(target==A[mid]){//target==A[mid]
    				return mid;
    			}
    		}
		}
        return -1;
    }

    //综合在一起写的方法，有点难懂
    public int search2(int[] A, int target) {
    	if(A==null||A.length==0)
     	   return -1;

    	int start=0;
        int end = A.length - 1;
        int mid = 0;
        
        while (start<=end) {
			mid = (start+end)/2;
			if(target==A[mid]){//target==A[mid]
				return mid;
			}
			if (A[mid]>=A[start]) {
				if(target>=A[start]&&target<A[mid])
					end = mid-1;
				else
					start = mid+1;
			}else {
				if(target<=A[end]&&target>A[mid])
					start = mid+1;
				else
					end = mid-1;
			}
		}
        return -1;
    }
    
}
