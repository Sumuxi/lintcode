package com.lintcode464;

/**464. 整数排序 II
 * 挑战： O(n log n) time
 * @author sumuxi
 *
 */
public class Solution {
    
	/**归并排序
     * @param A: an integer array
     * @return: 
     */
    public void sortIntegers2(int[] arr) {
        if(arr.length<=1)
        	return;
        mergeSort(arr, 0, arr.length-1);
    }

	private void mergeSort(int[] arr, int p, int r) {
		if(p<r){
			int q = (p+r)/2;
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q+1, r);
		}
	}

	private void merge(int[] arr, int p, int q, int r) {
		int[] array1 = new int[q-p];//需要开辟两处内存来做归并
		int[] array2 = new int[r-q+1];
		System.arraycopy(arr, p, array1, 0, q-p);
		System.arraycopy(arr, q, array2, 0, r-q+1);
		int i=0, j=0, k=p;
		while (i<array1.length&&j<array2.length) {
			if(array1[i]<array2[j]){
				arr[k++] = array1[i++];
			}else {
				arr[k++] = array2[j++];
			}
		}
		while (i<array1.length) {
			arr[k++] = array1[i++];
		}
		while (j<array2.length) {
			arr[k++] = array2[j++];
		}
	}
    
}
