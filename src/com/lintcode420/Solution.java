package com.lintcode420;

/**420. 报数
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println();
	}
	
	/**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        String seed = "1";
        StringBuilder sb = new StringBuilder();
        int s=1;
        while (s<n) {
			for (int i = 0; i < seed.length();) {
				int j=i+1;
				while(j<seed.length()&&seed.charAt(j)==seed.charAt(i)){
					j++;
				}
				sb.append(j-i);
				sb.append(seed.charAt(i));
				i=j;
			}
			seed = sb.toString();
			sb.delete(0, sb.length());
			s++;
		}
        return seed;
    }
	
}
