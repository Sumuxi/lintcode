package com.lintcode079;

/**79. 最长公共子串
 * 挑战：O(n x m) time and memory.
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}
	
	/**动态规划, O(m x n) time, O(n) memory
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
    	int n = B.length()+1;
        int[] c1 = new int[n];
        int[] c2 = new int[n];
        int max=0;
        for (int i=0; i<A.length(); i++) {
			for (int j=1; j<n; j++) {
				if(A.charAt(i)==B.charAt(j-1)){
					c2[j] = c1[j-1]+1;
					if(c2[j]>max){
						max=c2[j];
					}
				}
				else{
					c2[j] = 0;
				}
			}
			int[] temp = c1;
			c1 = c2;
			c2 = temp;
		}
        return max;
    }
	
	/**思路简单，把短的字符串去长的字符串里面逐次比对
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring1(String A, String B) {
        if(A==""||B=="")
        	return 0;
        
        int max1 = 0;
        int max2 = 0;
        if(A.length()<B.length()){//保证A比B长
        	String t = A;
        	A = B;
        	B = t;
        }
        int count = 0;
        int k;
        int j;
        for (int i=0; i<=A.length()-B.length(); i++) {
        	k = i;
        	j = 0;
        	while (j<B.length()) {
				while(j<B.length()&&A.charAt(k)==B.charAt(j)){
					k++;
					j++;
					count++;
				}
				k++;
				j++;
				if(count>max2)
					max2= count;
				count = 0;
			}
        	if(max2>max1)
        		max1 = max2;
		}
        return max1;
    }

}
