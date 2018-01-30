package com.lintcode114;

/**114. 不同的路径
 *  挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().uniquePaths(17, 18));
		System.out.println(new Solution().uniquePaths1(17, 18));
	}
	
	/**排列组合的方法，不是很好
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
    	if(m+n<=3){
    		return 1;
    	}
    	
    	int down = m+n-2;
    	int up = n-1;
    	up = up<down-up?up:down-up;
    	int arr[] = new int[up];
    	for (int i=0; i<arr.length; i++) {
			arr[i] = down--;
		}
    	
    	long p1=1;
    	for (int i = up; i>=2; i--) {
    		for (int j=0; j<arr.length; j++) {
				if (arr[j]%i==0) {
					arr[j] /=i;
					break;
				}
				if(j==arr.length-1){
					p1 *= i;
				}
			}
		}
    	long p2 = 1;
    	for (int i=0; i<arr.length; i++) {
			 p2 *= arr[i];
		}
    	return (int) (p2/p1);
    }
    
    //递推的思想，比较好
    public int uniquePaths1(int m, int n) {
    	int[] arr = new int[n];
    	for (int j = 0; j < arr.length; j++) {
			arr[j] = 1; 
		}
    	
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < arr.length; j++) {
				arr[j] += arr[j-1]; 
			}
		}
    	
    	return arr[arr.length-1];
    }

}
