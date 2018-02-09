package com.lintcode387;

/**387. 最小差
 * 挑战：时间复杂度 O(n log n)
 * @author sumuxi
 *
 */
public class Solution {

	/**数据量很大时TLE
     * @param A: An integer array
     * @param B: An integer array
     * @return: Their smallest difference.
     */
    public int smallestDifference1(int[] A, int[] B) {
        int min = Integer.MAX_VALUE;
    	for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int t = Math.abs(A[i]-B[j]);
//				if(t==0)
//					return 0;
				if(t<min){
					min = t;
				}
			}
		}
    	return min;
    }
    
    //JDK提供的快排平均复杂度为O(nlgn),然后用做二分查找,是O(nlgn),近似实现了挑战的要求
    public int smallestDifference(int[] A, int[] B) {
	    java.util.Arrays.sort(A);	
	    java.util.Arrays.sort(B);	
	    int min = Integer.MAX_VALUE;
	    int start, end, mid;
	    for (int i = 0; i < A.length; i++) {
	    	start = 0;
	    	end = B.length-1;
	    	while (start<=end) {
	    		mid = (start+end)>>>1;
	    		if (A[i]<B[mid]) {//左
	    			end = mid-1;
	    		}else if (A[i]>B[mid]) {//右
	    			start = mid+1;
	    		}else {//A[i]==B[mid]
	    			return 0;
	    		}
			}
	    	int t;
	    	if(start<B.length&&(t=Math.abs(A[i]-B[start]))<min)
	    		min = t;
	    	if(end>=0&&(t=Math.abs(A[i]-B[end]))<min)
	    		min = t;
		}
    	return min;
    }
	
}
