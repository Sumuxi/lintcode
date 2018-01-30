package com.lintcode075;

/**
 * 75. 寻找峰值
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

	}
	
	//挑战：Time complexity O(logN)
	
    /**O(n)
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
    	//A.length >= 3
        for(int i=1,j=A.length-2; i<A.length-1&&j>0; i++,j--){
            if(A[i+1]<A[i])
                return i;
            if (A[j-1]<A[j]) {
				return j;
			}
        }
		return -1;//因为题目说一定有峰值，所以这条语句没有作用，只是为了通过编译
    }

}
