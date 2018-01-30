package com.lintcode117;

/**117. 跳跃游戏 II
 *  挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
	}
	
	/**由题意知，一定可以从0跳到最后的位置，需要的是最少的跳跃次数
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
    	int[] arr = new int[A.length];
    	for (int i = 0; i < arr.length-1; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
    	arr[A.length-1] = 0;
        for (int i = A.length-2; i>=0; i--) {
        	if(A[i]<=0)
        		arr[i] = Integer.MAX_VALUE;
        	else
        		arr[i] = min(arr, i, i+A[i])+1;
		}
        return arr[0];
    }

	private int min(int[] arr, int i, int j) {
		int min = arr[i];
		for (int k = i+1; k<arr.length&&k<=j; k++) {
			if(arr[k]<min)
				min = arr[k];
		}
		return min;
	}
}
