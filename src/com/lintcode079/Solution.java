package com.lintcode079;

/**79. 最长公共子串
 * 挑战：O(n x m) time and memory.
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		
	}
	
	/**思路简单，把短的字符串去长的字符串里面逐次比对
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
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
