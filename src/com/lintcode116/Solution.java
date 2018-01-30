package com.lintcode116;

/**116. 跳跃游戏
 *  挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().canJump(new int[]{2,3,1,1,4}));
		System.out.println(new Solution().canJump(new int[]{3,2,1,0,4}));
	}
	
	/**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        int gap = 1;
        for (int i = A.length-2; i>=0; i--) {
			if(A[i]<gap){
				gap++;
			}else {
				gap=1;
			}
		}
        return gap==1;
    }
}
