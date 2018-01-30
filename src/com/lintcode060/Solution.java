package com.lintcode060;

/**60. 搜索插入位置
 * 挑战：O(log(n)) time
 * @author sumuxi
 *
 */
public class Solution {

	/**二分查找法
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        if(A==null||A.length==0)
        	return 0;
        
        int start = 0;
        int end = A.length -1;
        int mid;
        while(start<=end){
        	mid = (start+end)/2;
        	if(target<A[mid]){//left
        		end = mid-1;
        	}else if (target>A[mid]){//right
				start = mid+1;
			}else {//==
				return mid;
			}
        }
        return start;
    }
	
}
