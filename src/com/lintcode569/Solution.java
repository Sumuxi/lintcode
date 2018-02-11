package com.lintcode569;

/**569. 各位相加
 * 挑战：你可以不用任何的循环或者递归算法，在 O(1) 的时间内解决这个问题么？
 * @author sumuxi
 *
 */
public class Solution {
	
	/**循环法
     * @param num: a non-negative integer
     * @return: one digit
     */
	public int addDigits1(int num) {
    	StringBuilder sb = new StringBuilder();
        while (true) {
        	sb.append(num);
        	int sum=0;
        	for (int i = 0; i < sb.length(); i++) {
    			sum+=sb.charAt(i)-'0';
    		}
        	num = sum;
        	if(num<10)
        		return num;
        	sb.delete(0, sb.length());
		}
    }
	
	//通过枚举发现有规律,即若数为9的倍数,则结果为9,若不是则结果为对九取余
	public int addDigits(int num) {
		if (num == 0)
			return 0;  
	       
		int result = num % 9;  
		if (result == 0)
			return 9;
		return result;  
	}
    
}
