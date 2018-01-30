package com.lintcode111;

/**111. 爬楼梯
 *  挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}

	/**到达第n阶楼梯，需要从n-1阶走一步，或者从n-2阶走两步
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if(n<=0){
            return 0;
        }
        int f1=0;
        int f2=1;
        int i=0;
        while(i<n){
        	f2 = f1+f2;
        	f1 = f2-f1;
        	i++;
        }
        return f2;
    }
}
