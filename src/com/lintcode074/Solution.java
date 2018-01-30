package com.lintcode074;

/**74. 第一个错误的代码版本
 * 挑战：调用 isBadVersion 的次数越少越好
 * @author sumuxi
 *
 */
public class Solution {

	/**二分法，这里用无符号右移很好，不仅速度快，而且也避免了被除数溢出变为负数。JDK里二分查找就是无符号右移
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
    	int start = 1;
        int end = n;
        int mid;
        while(start<=end){
        	mid = (start+end)>>>1;
        	if(SVNRepo.isBadVersion(mid)){
        		end = mid-1;
        	}else {
				start = mid+1;
			}
        }
    	return start;
    }
    
    /*
     * 这个方法不好，尤其是除2或者带符号右移一位，都不能避免被除数溢出问题
     */
    public int findFirstBadVersion1(int n) {
        if(!SVNRepo.isBadVersion(n-1))
            return n;
        
    	int start = 1;
        int end = n;
        int mid;
        while(start<=end){
        	mid = (start+end)/2;
        	if(SVNRepo.isBadVersion(mid)){
        		end = mid-1;
        	}else {
				start = mid+1;
			}
        }
    	return start;
    }  
	
}

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class SVNRepo {

	public static boolean isBadVersion(int k){
		return false;
	}

}

