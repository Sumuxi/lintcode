package com.lintcode065;

/**65. 两个排序数组的中位数
 * 挑战：时间复杂度为O(log n)
 * @author sumuxi
 *
 */
public class Solution {

	private int tiaozhan = -1;
	public static void main(String[] args) {
		
	}
	
	/**归并排序的思路，未实现挑战
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length+B.length;
    	int count = 0;
    	int i = 0;
    	int j = 0;
    	int t1 = 0;
    	
    	if(len%2==1){//奇数个
    		while(i<A.length&&j<B.length){
        		if(A[i]<=B[j]){
        			count++;
        			if(count==len/2+1){
        				return A[i];
        			}
        			i++;
        		}else {
        			count++;
        			if(count==len/2+1){
        				return B[j];
        			}
        			j++;
    			}
        	}
        	while(i<A.length){
        		count++;
    			if(count==len/2+1){
    				return A[i];
    			}
    			i++;
        	}
        	while(j<B.length){
        		count++;
    			if(count==len/2+1){
    				return B[j];
    			}
    			j++;
        	}
        	
    	}else{
    		while(i<A.length&&j<B.length){
        		if(A[i]<=B[j]){
        			count++;
        			if(count==len/2){
        				t1 = A[i];
        			}
        			if(count==len/2+1){
        				return ((double)t1+A[i])/2;
        			}
        			i++;
        		}else {
        			count++;
        			if(count==len/2){
        				t1 = B[j];
        			}
        			if(count==len/2+1){
        				return ((double)t1+B[j])/2;
        			}
        			j++;
    			}
        	}
        	while(i<A.length){
        		count++;
    			if(count==len/2){
    				t1 = A[i];
    			}
    			if(count==len/2+1){
    				return ((double)t1+A[i])/2;
    			}
    			i++;
        	}
        	while(j<B.length){
        		count++;
    			if(count==len/2){
    				t1 = B[j];
    			}
    			if(count==len/2+1){
    				return ((double)t1+B[j])/2;
    			}
    			j++;
        	}
    	}
    	return -1;
    }
    
    public double findMedianSortedArrays1(int[] A, int[] B) {
        int len = A.length+B.length;
    	int count = 0;
    	int i = 0;
    	int j = 0;
    	int t1 = 0;
    	
    	if(len%2==1){//奇数个
    		while(i<A.length&&j<B.length){
    			count++;
    			if(count==len/2+1)
        			return A[i]<=B[j]?A[i]:B[j];
        		if(A[i]<=B[j])
        			i++;
        		else 
        			j++;
        	}
        	while(i<A.length){
        		count++;
    			if(count==len/2+1){
    				return A[i];
    			}
    			i++;
        	}
        	while(j<B.length){
        		count++;
    			if(count==len/2+1){
    				return B[j];
    			}
    			j++;
        	}
        	
    	}else{
    		while(i<A.length&&j<B.length){
        		if(A[i]<=B[j]){
        			count++;
        			if(count==len/2){
        				t1 = A[i];
        			}
        			if(count==len/2+1){
        				return ((double)t1+A[i])/2;
        			}
        			i++;
        		}else {
        			count++;
        			if(count==len/2){
        				t1 = B[j];
        			}
        			if(count==len/2+1){
        				return ((double)t1+B[j])/2;
        			}
        			j++;
    			}
        	}
        	while(i<A.length){
        		count++;
    			if(count==len/2){
    				t1 = A[i];
    			}
    			if(count==len/2+1){
    				return ((double)t1+A[i])/2;
    			}
    			i++;
        	}
        	while(j<B.length){
        		count++;
    			if(count==len/2){
    				t1 = B[j];
    			}
    			if(count==len/2+1){
    				return ((double)t1+B[j])/2;
    			}
    			j++;
        	}
    	}
    	return -1;
    }
    
}
