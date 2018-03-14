package com.lintcode029;

/**29. 交叉字符串
 * 挑战：要求时间复杂度为O(n^2)或者更好
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

		System.out.println(new Solution().isInterleave("sdfjas;dfjoisdufzjkndfasdkfja;sdfa;dfa;dfaskdjhfasdhjdfakhdgfkajdfasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfhakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh", 
				"dfnakdjnfjkzghdufguweygfasjkdfgb2gf8asf7tgbgasjkdfgasodf7asdgfajksdfguayfgaogfsdkagfsdhfajksdvfbgkadsghfakdsfgasduyfgajsdkfgajkdghfaksdgfuyadgfasjkdvfjsdkvfakfgauyksgfajkefgjkdasgfdjksfgadjkghfajksdfgaskdjfgasjkdgfuyaegfasdjkfgajkdfygadjskfgjkadfg",
				"sdfjas;dfjoisdfnakdjnfjkzghdufguwdufzjkeygfasjkdfgb2gf8asf7ndtgbgasjkdfgasodf7asdfgfajkasdksdfguayfgaogfsdkagfsfjadhfajksdvfbgkadsghfa;sdkdsfgasduyfgajsdkfgafajkdghfaksdgfuyadgfas;dfjkdvfjsdkvfakfgauyksa;dgfajkefgjkdasgfdjksffaskdjhfasdhjdfakhdgadjkghfajgfkajdfksdfgaskdjfgasjkdgfuasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfyaegfasdjkfgajkdfygadjskfgjkadfghakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh"));
	}
	
	/**DP问题，可以转换为二维矩阵从图的左上角到右下角是否有通路的问题
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
	public boolean isInterleave(String s1, String s2, String s3) {
    	int i=0,j=0,k=0;
    	java.util.Stack<index> stack = new java.util.Stack<index>();//放置回退的起始位置
    	while(k<s3.length()){
    		if(i<s1.length()&&j<s2.length()&&s2.charAt(j)==s1.charAt(i)&&s2.charAt(j)==s3.charAt(k)){
    			stack.push(new index(i, j, k));
    		}
    		if(i<s1.length()&&s3.charAt(k)==s1.charAt(i)){
    			i++;
    			k++;
    		}else if(j<s2.length()&&s3.charAt(k)==s2.charAt(j)){
    			j++;
    			k++;
    		}else{
    			if(stack.isEmpty()){
    				return false;
    			}else {
					index item = stack.pop();
					i = item.i;
					j = item.j;
					k = item.k;
					j++;
					k++;
				}
    		}
    	}
    	return true;
    }
    
    class index{
    	int i;
    	int j;
    	int k;
    	
		public index(int i, int j, int k) {
			super();
			this.i = i;
			this.j = j;
			this.k = k;
		}
    }

}

