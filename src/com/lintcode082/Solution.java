package com.lintcode082;

/**
 * 82. 落单的数
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

	}
	
	//挑战：一次遍历，常数级的额外空间复杂度
	private int 没有实现;
	
	/**使用一个栈，未实现挑战要求
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here

    	java.util.HashSet<Integer> set = new java.util.HashSet<Integer>();
    	
    	for (int i : A) {
			if (set.contains(i)) {
				set.remove(i);
			}else {
				set.add(i);
			}
		}
    	return set.iterator().next();//由题意，最后剩下的一定是 落单的数
    }
	
}
