package com.lintcode179;

/**179. 更新二进制位
 * 挑战：最少的操作次数是多少？
 * @author sumuxi
 *
 */
public class Solution {
    
	/**由题意，0<=i<=j<=31,而且j==M的有效位的数位
     * @param n: An integer
     * @param m: An integer
     * @param i: A bit position
     * @param j: A bit position
     * @return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
    	n = n>>>i|n<<(32-i);//n循环右移
    	for (int k=i; k<=j; k++) {
    		if((m&0x01)==0){
    			n = n>>>1;
			}else {
				n = n|0x01;
				n = n>>>1|n<<31;
			}
			m = m>>>1;
		}
    	n = n<<(j+1)|n>>>(32-j-1);//n循环左移
    	return n;
    }
    
}
