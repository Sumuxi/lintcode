package com.lintcode042;

import java.util.List;

/**42. 最大子数组 II
 * @author sumuxi
 *
 */
public class Solution3 {

	public static void main(String[] args) {

//		System.out.println(maxSubArray(new int[]{-1, 2, -1}));
		
		int[] arr = new int[]{-28,-75,100,-26,-80,-26,-47,
				63,59,-84,-54,48,64,-34,-48,80,38,-76,-59,-10,-67};
		java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		System.out.println(maxTwoSubArrays(list));
	}
	
	/**64%通过
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public static int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
    	
    	int[] negNum = new int[2];//保存两个最大的负数
    	negNum[0] = Integer.MIN_VALUE;
    	negNum[1] = negNum[0];
    	
    	int start=0;//正数开始的索引
    	int end=nums.size()-1;//正数结束的索引(含)
    	while (start<nums.size()&&nums.get(start)<=0) {
			insert(negNum, nums.get(start));
			start++;
		}
    	while (end>start&&nums.get(end)<=0) {
			insert(negNum, nums.get(end));
			end--;
		}
    	
    	//如果数组仅包含非正数，则两个最大非正数之和即为所求
    	if (start == nums.size()) {
			return negNum[0]+negNum[1];
		}
    	//仅有一个正数
    	if (start == end) {
			return negNum[0]+nums.get(start);
		}
    	
		int pSum = 0;//连续正数的和(含0) positive sum
		int nSum = 0;//连续负数的和		negative sum
		int nMin = 0;//这一批正数中出现的最小的负数	negative min
		int tempMax=0;

		java.util.ArrayList<Integer> plist = new java.util.ArrayList<Integer>();//连续正数的和组成的表
		for (int i = start; i <= end; i++) {
			if (nums.get(i)<0) {
				do{
					nSum += nums.get(i++);
				}while (i<=end&&nums.get(i)<0);
				i--;
				
				if (nSum<nMin) {
					nMin=nSum;
				}
				pSum = 0;
				
				
			}else {//nums.get(i)>=0
				do{
					pSum += nums.get(i++);
				}while (i<=end&&nums.get(i)>=0);
				i--;
				
				if (plist.size()==0) {
					plist.add(pSum);
					tempMax = pSum;
				}else {
					int tail = plist.size()-1;
					if (plist.get(tail)+nSum>=0){
						tempMax += pSum+nSum;
					}
					plist.add(pSum);
				}
				nSum = 0;//清零
			}
		}
    	
    	if (plist.size()==1) {//plist.size()==1
			return plist.get(0)-nMin;
		}else {//plist.size()>=2
			java.util.Collections.sort(plist);
			int tail = plist.size()-1;
			return plist.get(tail)+plist.get(tail-1);
		}
    }

	public static void insert(int[] arr, int value) {
		if(value>arr[0]){
			arr[1] = arr[0];
			arr[0] = value;
		}else if (value>arr[1]) {
			arr[1] = value;
		}
	}

}
