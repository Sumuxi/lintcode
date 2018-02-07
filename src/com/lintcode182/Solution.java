package com.lintcode182;

/**182. 删除数字
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
	
	private int 没做出来;
    
	/**N <= 240, k <= N
     * @param A: A positive integer which has N digits, A is a string
     * @param l: Remove k digits
     * @return: A string
     */
	public String DeleteDigits(String A, int l) {
    	char[] str = A.toCharArray();
        char[] arr1 = new char[A.length()];
        int end = A.length()-1;
        int index = findMin(str, 0, end);
        for (int i=0; i<str.length-l; i++) {
        	arr1[index] = str[index];
        	str[index] = 'a';
        	if(index==end){
        		end--;
        		int start = end;
        		while(start>=0&&str[start]=='a'){
        			start--;
        		}
        		while(start>=0&&str[start]!='a'){
        			start--;
        		}
        		index = findMin(str, ++start, end);
        	}else {
				index = findMin(str, index+1, end);
			}
		}
        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]>='0'){
				arr1[j++] = arr1[i]; 
			}
		}
        int i = 0;
        while (i<j&&arr1[i]=='0') {
        	i++;
		}
        return new String(arr1, i, j-i);
    }

	private int findMin(char[] str, int index, int end) {
		int j = index;
		char t = str[index];
		for (int i=index+1; i<=end; i++) {
			if(str[i]<t){
				j = i;
				t = str[i];
			}
		}
		return j;
	}

}
