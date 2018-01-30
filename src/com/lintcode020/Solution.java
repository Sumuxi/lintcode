package com.lintcode020;

import java.util.List;
import java.util.Map;

/**
 * 20. 骰子求和
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

		Solution s = new Solution();
		System.out.println(s.dicesSum(1));
		System.out.println(s.dicesSum(2));
		System.out.println(s.dicesSum(3));
		System.out.println(s.dicesSum(5));
		System.out.println(s.dicesSum(15));
	}

	/**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
    	
    	//n>=1
    	double down = Math.pow(6, n); //分母
//    	double up;//分子
    	int num = 5*n+1;//和的个数
    	int start = n;//和的起始数
    	int end = start+num-1;//和的结尾数
    	
    	long[] list1 = new long[]{1,1,1,1,1,1};
    	long[] list2 = list1;
    	if (n>1) {
    		int t = 2;
	    	while(t<=n){
	    		list2 = new long[5*t+1];
	    		int i;
	    		for (i= 0; i <= (list2.length-1)/2; i++) {
	    			list2[i] = sum(i, list1);
	    		}
	    		if (list2.length%2==0) {//偶数
	    			for (int j=i--; j<list2.length; j++) {
	    				list2[j] = list2[i--];
	        		}
				}else {//奇数
					i -= 2;
					for (int j=i+2; j<list2.length; j++) {
	    				list2[j] = list2[i--];
	        		}
				}
	    		list1 = list2;
	    		t++;
	    	}
		}
//    	print(list2);
    	List<Map.Entry<Integer, Double>> list = new java.util.ArrayList<Map.Entry<Integer, Double>>();
    	int j = 0;
    	for (int i=start; i<=end; i++) {
			list.add(new java.util.AbstractMap.SimpleEntry<Integer, Double>(i, list2[j++]/down));
		}
    	return list;
    }

    private long sum(int i, long[] list) {
		long s = 0;
		if (i<5) {
			for (int j = 0; j <= i; j++) {
				s += list[j];
			}
		}else {
			for (int j=i; j>i-6; j--) {
				s += list[j];
			}
		}
		return s;
	}
    
	public void print(long[] list) {
		System.out.print("[");
		int i;
		for (i= 0; i < list.length-1; i++) {
			System.out.print(list[i]+",");
		}
		System.out.println(list[i]+"]");
	}

}
