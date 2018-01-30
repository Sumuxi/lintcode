package com.lintcode033;

import java.util.List;

/**33. N皇后问题
 * 挑战：不使用递归完成
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
    		putQueen(arr, i);
    	}
        
        return null;
    }

	private void putQueen(int[] arr, int i) {
		if(i==arr.length)
			return;
		
		
	}
    
}
