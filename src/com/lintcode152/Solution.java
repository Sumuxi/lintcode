package com.lintcode152;

import java.util.List;

/**152. 组合
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {
	
	/**回溯法
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
    	findCombination(1, n, k);
    	return result;
    }

    private List<List<Integer>> result = new java.util.ArrayList<List<Integer>>();
    private List<Integer> list = new java.util.ArrayList<Integer>();
	private void findCombination(int i, int n, int k) {
		if(list.size()==k){
			List<Integer> t= new java.util.ArrayList<Integer>(list.size());
			for (int j = 0; j < list.size(); j++) {
				t.add(new Integer(list.get(j)));
			}
			result.add(t);
			return;
		}

		for (int j = i; j<=n&&j<=n-k+i; j++) {
			list.add(j);
			findCombination(j+1, n, k);
			list.remove(list.size()-1);
		}
	}
    
}
