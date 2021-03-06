package com.lintcode003;

/** 3. 统计数字 ,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(digitCounts(1, 12));
	}
	
	/*
	 *思路：暴力法，穷尽分析
	 *	编程之美这本书上提到了一种不错的解法，有时间再来补充
	 */
	
	/**
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public static int digitCounts1(int k, int n) {
        // write your code here
        String numK = ""+k;
        StringBuilder numN= new StringBuilder();
        int count = 0;
        for(int i=0; i<=n; i++)
        {
            numN.append(""+i);
            int start = 0;
            while((start=numN.indexOf(numK,start))!=-1){
                count++;
                start++;
            }
            numN.delete(0, numN.length());
        }
        return count;
    }
    
    public static int digitCounts(int k, int n) {
        // write your code here
        char numK = (char)('0'+k);
        StringBuilder numN= new StringBuilder();
        int count = 0;
        for(int i=0; i<=n; i++)
        {
            numN.append(""+i);
            int index = 0;
            while(index<numN.length()){
                if(numN.charAt(index)==numK)
                	count++;
                index++;
            }
            numN.delete(0, numN.length());
        }
        return count;
    }
    
}
