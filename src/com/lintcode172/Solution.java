package com.lintcode172;

/**172. 删除元素
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**两根指针
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        int i=0;
        for (int j = 0; j < A.length; j++) {
			if(A[j]!=elem){
				A[i++] = A[j];
			}
		}
        return i;
    }
	
}
