package com.lintcode792;

/**792. Kth Prime Number
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(new Solution().kthPrime(2));
		System.out.println(new Solution().kthPrime(3));
		System.out.println(new Solution().kthPrime(5));
		System.out.println(new Solution().kthPrime(7));
		System.out.println(new Solution().kthPrime(11));
		System.out.println(new Solution().kthPrime(13));
	}
	
	/**
     * @param n: the number
     * @return: the rank of the number
     */
	public int kthPrime1(int n) {
        assert n>1;
        if(n==2)
        	return 1;
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
    	list.add(2);
    	list.add(3);
    	int num=5;
    	while(list.get(list.size()-1)<n){
    		int j=0;
    		while(j<list.size()&&num%list.get(j)!=0){
    			j++;
    		}
    		if(j==list.size()){
    			list.add(num);
    		}
    		num++;
    	}
    	return list.size();
    }
	
	public int kthPrime(int n) {
        assert n>1;
        if(n==2)
        	return 1;
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
    	list.add(2);
    	int num=3;
    	out:while(true){
    		int j=0;
    		while(j<list.size()&&num%list.get(j)!=0){
    			if(list.get(j)*list.get(j)>num){
    				System.out.println("aaa: "+num);
    				list.add(num);
    				if(num==n){
    					num+=2;
    					break out;
    				}
    			}
    			j++;
    		}
    		num+=2;
    	}
    	System.out.println(list);
    	return list.size();
    }
	
}
