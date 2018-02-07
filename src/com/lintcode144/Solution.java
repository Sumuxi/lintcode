package com.lintcode144;

/**144. 交错正负数
 * 挑战：原地完成，没有额外的空间
 * @author sumuxi
 *
 */
public class Solution {
	
	/**先将数组划分为正数和负数，再进行交错处理
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
    	int i = 0;
		for (int j = 0; j < A.length; j++) {
			if(A[j]<=0){
				int t = A[j];
				A[j] = A[i];
				A[i++] = t;
			}
		}
		//负数的个数为i，正数的个数为A.length-i
		int j;
    	if(i>=A.length-i)//负数个数>=正数,从1下标开始填正数
    		j=1;
    	else	//从0下标开始填正数
    		j=0;
    	for (int k=i; k<A.length; k++, j+=2) {
			int t = A[j];
			A[j] = A[k];
			A[k] = t;
		}
    }
    
    //将数组按照负数和正数划分
	public void partition(int[] arr, int pivot) {
		int i = 0;
		for (int j = 0; j < arr.length; j++) {
			if(arr[j]<=pivot){
				int t = arr[j];
				arr[j] = arr[i];
				arr[i++] = t;
			}
		}
	}
    
}
