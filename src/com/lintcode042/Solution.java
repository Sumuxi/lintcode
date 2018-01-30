package com.lintcode042;

import java.util.ArrayList;
import java.util.List;

/**42. 最大子数组 II,Wrong Answer
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

//		System.out.println(maxSubArray(new int[]{1, 3, -1, 2, -1, 2}));
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(-1);
		list.add(2);
		list.add(-1);
		list.add(2);
		System.out.println(maxTwoSubArrays(list));
	}
	
	/**思路太复杂
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
    	if (start == nums.size()||(nums.get(start)<=0&&start==end)) {
			return negNum[0]+negNum[1];
		}
    	
		int pSum = 0;//连续正数的和(含0)
		int nSum = 0;//连续负数的和
		boolean notAddP=false;
		boolean notAddN=false;

    	ArrayList<Integer> plist = new ArrayList<Integer>();//连续正数的和组成的表
    	ArrayList<Integer> nlist = new ArrayList<Integer>();//连续负数的和组成的表
    	for (int i = start; i <= end; i++) {
			if (nums.get(i)<0) {
				nSum += nums.get(i);
				notAddN=true;
				
				if (notAddP) {
					plist.add(pSum);
					pSum = 0;
					notAddP = false;
				}
			}else {
				pSum += nums.get(i);
				notAddP=true;
				
				if (notAddN) {
					nlist.add(nSum);
					nSum=0;
					notAddN = false;
				}
			}
			if (i==end) {//最后在累和的一定是正数
				plist.add(pSum);
				break;
			}
		}
    	
    	if (plist.size()<3) {//plist.size()==1||2
    		int max=0;
    		for (int i = 0; i < plist.size(); i++) {
				max += plist.get(i);
			}
			return max;
		}else {//plist.size()>=3
			ArrayList<Integer> temp = new ArrayList<Integer>(10);
//			System.out.println("p:n "+plist.size()+" "+nlist.size());
			int index = 0;
			temp.add(plist.get(index));
			for (int i = 0; i < nlist.size(); i++) {
				int val;
				if ((val=plist.get(i+1)+nlist.get(i))>=0&&plist.get(i)+nlist.get(i)>=0) {
					temp.set(index,temp.get(index)+val);
				} else {
					index++;
					temp.add(plist.get(i+1));
				}
				
			}
			
			if (temp.size()==1) {
				return temp.get(0)-java.util.Collections.min(nlist);
			}else {//temp.size()>=2
				int max1 = java.util.Collections.max(temp);
				temp.remove(new Integer(max1));
				int max2 = java.util.Collections.max(temp);
				return max1+max2;
			}
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
