package com.lintcode130;

/**130. 堆化
 * 挑战：O(n)的时间复杂度完成堆化
 * @author sumuxi
 *
 */
public class Solution {
    
	/**以下方法的时间复杂度为O(n)
     * @param A: Given an integer array
     * @return: nothing
     */
	public void heapify(int[] A) {
        if(A.length<=1)
            return;
        for (int i=((A.length-2)>>>1); i>=0; i--) {
			minHeapify(A, i);
		}
    }
    
    public void minHeapify(int[] A, int i){
    	int l = (i<<1)|0x01;
    	int r = (i<<1)+2;
    	int smallest = i;
    	if(l<A.length&&A[l]<A[i])
    		smallest = l;
    	if(r<A.length&&A[r]<A[smallest])
    		smallest = r;
    	if(smallest!=i){
    		int t = A[i];
    		A[i] = A[smallest];
    		A[smallest] = t;
    		minHeapify(A, smallest);
    	}
    }
	
}
