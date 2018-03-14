package com.lintcode004;

import java.util.ArrayList;

/** 4. 丑数 II,AC
 * @author sumuxi
 *
 */
public class Solution2 {
	
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1665));
	}
	
	/* 思路：典型的递推法解题；
	 * 使用递推的思想，找出前后的规律，形成递推关系
	 * 
	 */
	
	/**使用三个索引，分别跟踪每个质数因子的倍数，确定下一个最小的丑数
	 * 下一个丑数,一定是前面的丑数的2倍,3倍或5倍,就是这三个数第一次大于最后一个元素时的最小者 
     * @param n: An integer
     * @return: the nth prime number as description.
	 * @throws Exception 
     */
    public static int nthUglyNumber(int n) {
    	if (n<=0) {
			throw new RuntimeException("invalid parameter！");
		}
    	if (n<7) {
			return n;
		}

    	ArrayList<Integer> list = new ArrayList<Integer>(100);
    	for (int i = 0; i < 6; i++) {
			list.add(i+1);
		}
    	
    	int index2 = 0;
    	int index3 = 0;
    	int index5 = 0;
    	
    	while (list.size()<n) {
    		int tail = list.size()-1;
			
    		while (list.get(index2)*2<=list.get(tail)) {
				index2++;
			}
    		while (list.get(index3)*3<=list.get(tail)) {
    			index3++;
    		}
    		while (list.get(index5)*5<=list.get(tail)) {
    			index5++;
    		}
    		list.add( min(list.get(index2)*2,min(list.get(index3)*3,list.get(index5)*5)) );
		}

//    	for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i)+" ");
//		}
    	return list.get(n-1);
    }

	public static int min(int a,int b) {
		// TODO Auto-generated method stub
		return a<=b?a:b;
	}
    
}
