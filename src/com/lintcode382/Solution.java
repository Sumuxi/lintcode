package com.lintcode382;

/**382. 三角形计数
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
//    	if(S.length<3)
//    		return 0;
    	int count = 0;
        for (int i=0; i<=S.length-3; i++) {
			for (int j = i+1; j <= S.length-2; j++) {
				for (int k = j+1; k <= S.length-1; k++) {
					int a,b,c;//分别代表三条边, 并使得a为最长的边
					if(S[i]>S[j]){
						a = S[i];
						b = S[j];
					}else {
						a = S[j];
						b = S[i];
					}
					if(a<S[k]){
						c = a;
						a = S[k];
					}else {
						c = S[k];
					}
					if(b+c>a){//两边之和大于第三边
						count++;
					}
				}
			}
		}
        return count;
    }
	
}
