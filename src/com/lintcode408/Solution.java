package com.lintcode408;

/**408. 二进制求和
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	/**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
    	//使a.length()>=b.length()
    	if(a.length()<b.length()){
    		String t = a;
    		a = b;
    		b = t;
    	}
    	int sum = 0;//本位和
    	int p = 0 ;//低位给本位的进位
    	char[] arr = new char[a.length()+1];
    	int k = arr.length-1;
    	for (int i=a.length()-1,j=b.length()-1; i>=0; i--) {
    		sum = a.charAt(i)-'0'+p;
    		if(j>=0)
    			sum+=b.charAt(j--)-'0';
			if(sum>=2){
				arr[k--] = (char)(sum-2+'0');
				p=1;
			}else {
				arr[k--] = (char)sum;
				p=0;
			}
		}
    	if(p==1){
    		arr[0] = '1';
    		return new String(arr);
    	}
    	return new String(arr, 1, arr.length-1);
    }
	
}
