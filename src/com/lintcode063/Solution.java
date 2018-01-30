package com.lintcode063;

/**63. 搜索旋转排序数组 II
 * 
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
//		System.out.println(java.util.Arrays.binarySearch(new int[]{1,2,3}, 2, 3, 3));
		System.out.println(new Solution().search(new int[]{4,5,6,1,2,3}, 1));
		
	}
	
	/**二分查找的思想，AC
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    public boolean search(int[] A, int target) {
    	if(A==null||A.length==0)
      	   return false;

     	int start=0;
         int end = A.length - 1;
         int mid = 0;
         
         if(target>=A[0]){//在前半段
         	while (start<=end) {
     			mid = (start+end)/2;
     			if(target==A[mid]){//target==A[mid]
     				return true;
     			}
     			if (A[mid]>=A[0]&&target>A[mid]) {
 					start = mid+1;
 				}else {
 					end = mid-1;
 				}
     		}
         	
         }else if(target<=A[A.length - 1]){//在后半段
         	while (start<=end) {
     			mid = (start+end)/2;
     			if(target==A[mid]){//target==A[mid]
     				return true;
     			}
     			if (A[mid]<=A[A.length - 1]&&target<A[mid]) {
 					end = mid-1;
 				}else{
     				start= mid+1;
     			}
     		}
 		}
         return false;
    }

}
