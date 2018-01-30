package com.lintcode142;

/**142. O(1)时间检测2的幂次
 * 挑战：O(1) time
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param n: An integer
     * @return: True or false
     */
	public boolean checkPowerOf21(int n) {
        if(n<=0){
        	return false;
        }
        
        int i=0;
        int count=0;
        while(i++<31){
        	if((n&0x01)==1)
        		count++;
        	n = n>>>1;
        }
        return count==1;        	
    }
	
	//算法思想：判断(n&(n-1))==0是否成立,因为2的幂次n的二进制只有一位为1，而n-1的二进制则恰好除了n为1的那位为0之外其余位都为1
	public boolean checkPowerOf2(int n) {
        if (n < 1)
            return false;
        else 
            return (n & (n - 1)) == 0;
    }
    
}
