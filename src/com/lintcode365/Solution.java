package com.lintcode365;

/**365. 二进制中有多少个1
 * 挑战：If the integer is n bits with m 1 bits. Can you do it in O(m) time?
 * @author sumuxi
 *
 */
public class Solution {
    
	/**普通方法
     * @param num: An integer
     * @return: An integer
     */
    public int countOnes1(int num) {
        int count = 0;
    	while(num!=0){
        	if((num&0x01)>0){
        		count++;
        	}
        	num = num>>>1;
        }
    	return count;
    }
    
    /**快速法
     * 这种方法速度比较快，其运算次数与输入n的大小无关，只与n中1的个数有关。
     * 如果n的二进制表示中有k个1，那么这个方法只需要循环k次即可。
     * 其原理是不断清除n的二进制表示中最右边的1，同时累加计数器，直至n为0。
     */
    public int countOnes(int num) {
        int count = 0;
    	while(num!=0){
        	num = num&(num-1);
        	count++;
        }
    	return count;
    }
	
}
