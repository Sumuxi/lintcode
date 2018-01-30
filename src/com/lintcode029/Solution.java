package com.lintcode029;

/**
 * 29. 交叉字符串
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

		System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
	
	/**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
    	if(s1.length()+s2.length()!=s3.length()){
    		return false;
    	}
    	boolean flag = false;
    	check(s1,s2,s3,0,0,0,flag);
    	return flag;
    }

	private void check(String s1, String s2, String s3, int index1, int index2, int index3, boolean flag) {
		if (index1==s1.length()&&index2==s2.length()&&index3==s3.length()) {
			flag = true;
		}
		if (index3<s3.length()) {
			char ch = s3.charAt(index3);
			if (index1<s1.length()&&ch == s1.charAt(index1)) {
				check(s1,s2,s3,index1+1,index2,index3+1,flag);
				if(!flag){
					if (index2<s2.length()&&ch == s2.charAt(index2)) {
						check(s1,s2,s3,index1,index2+1,index3+1,flag);
					}
				}
				
			}else if (index2<s2.length()&&ch == s2.charAt(index2)) {
				check(s1,s2,s3,index1,index2+1,index3+1,flag);
				if(!flag){
					if (index1<s1.length()&&ch == s1.charAt(index1)) {
						check(s1,s2,s3,index1+1,index2,index3+1,flag);
					}
				}
			}
		}
	}

}

