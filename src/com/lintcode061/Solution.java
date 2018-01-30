package com.lintcode061;

/**61. 搜索区间
 * 挑战：时间复杂度 O(log n)
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		int[] result = new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
		System.out.println(result[0]+" "+result[1]);
		
	}
	
	/**二分查找法
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
       if(A==null||A.length==0)
    	   return new int[]{-1,-1};
       
       int start=0;
       int end = A.length - 1;
       int mid = 0;
       boolean flag = false;//是否有target
       while(start<=end){
    	   mid = (start+end)/2;
    	   if(target<A[mid]){
    		   end = mid-1;
    	   }else if (target>A[mid]) {
    		   start = mid + 1;
    	   }else{//==
    		   flag = true;
    		   break;
    	   }
       }
       if(flag==false){
    	   return new int[]{-1,-1};
       }else{
    	   int[] result = new int[2];
    	   result[0] = mid;
    	   while(result[0]>=0&&A[result[0]]==target){
    		   result[0]--;
    	   }
    	   result[0]++;
    	   
    	   result[1] = mid;
    	   while(result[1]<A.length&&A[result[1]]==target){
    		   result[1]++;
    	   }
    	   result[1]--;
    	   return result;
       }
       
    }
    
}
