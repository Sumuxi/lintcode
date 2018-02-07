package com.lintcode187;

/**187. 加油站
 * 挑战：O(n)时间和O(1)额外空间
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int vol;//开始时油箱中油的容量
        for (int i = 0; i < gas.length; i++) {
            vol = 0;
        	int j = i;
        	while (true) {
        		vol = vol+gas[j]-cost[j];
    			if(vol<0){
    				break;
    			}
    			j = (++j)%gas.length;
    			if(j==i){
    				return i;
    			}
			}
		}
        return -1;
    }
	
}
