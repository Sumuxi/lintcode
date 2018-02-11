package com.lintcode463;

/**463. 整数排序
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**插入排序
     * @param A: an integer array
     * @return: 
     */
	public void sortIntegers(int[] arr) {
    	if(arr.length<=1){
    		return;
    	}
    	for (int i = 1; i < arr.length; i++) {
    		int j = i-1;
    		int t = arr[i];
			while (j>=0&&arr[j]>t) {
				arr[j+1] = arr[j--];
			}
			arr[j+1] = t;
		}
    }
    
}
