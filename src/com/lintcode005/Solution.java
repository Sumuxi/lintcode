package com.lintcode005;

/**
 * 5. 第k大元素 ,AC
 * 
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[] {9,3,2,4,8 };
		System.out.println(kthLargestElement( 3, nums));
//		for (int i = 0; i < nums.length; i++) {
//			System.out.print(nums[i] + " ");
//		}
	}

	/**
	 * 连续比较k轮找出第k大元素,超时
	 * @param k: description of k
	 * @param nums: array of nums
	 * @return: description of return
	 */
	public static int kthLargestElement1(int k, int[] nums) {
		// write your code here
		int max;
		int index = -1;
		for (int j = 0; j < k; j++) {

			max = Integer.MIN_VALUE;
			for (int i = j; i < nums.length; i++) {
				if (nums[i] >= max) {
					max = nums[i];
					index = i;
				}
			}

			int temp = nums[j];
			nums[j] = nums[index];// 最大值
			nums[index] = temp;
		}

		return nums[k - 1];
	}

	/**
	 * 使用库函数中的快排方法，不会超时
	 * @param k
	 * @param nums
	 * @return
	 */
	public static int kthLargestElement2(int k, int[] nums) {
		// write your code here
		java.util.Arrays.sort(nums);
		return nums[nums.length - k];
	}

	/**
	 * 自己实现快排算法
	 * 
	 * @param k
	 * @param nums
	 * @return
	 */
	public static int kthLargestElement3(int k, int[] nums) {
		// write your code here
		int meiyonshixian;

		return 0;
	}

	/** 通过
	 * @param k
	 * @param nums
	 * @return
	 */
	public static int kthLargestElement(int k, int[] nums) {
		// write your code here
		int[] arr = new int[k];//保存前K大数的数组
		arr[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < k; j++) {
				if (nums[i] > arr[j]) {
					int t = k - 1;
					for (; t > j; t--) {
						arr[t] = arr[t - 1];
					}
					arr[j] = nums[i];
					break;
				}
			}
		}
		return arr[k - 1];
	}

	private static void insert(int[] arr, int index, int value) {
		// TODO Auto-generated method stub
		for (int i = arr.length - 1; i > index; i--) {
			arr[i] = arr[i - 1];
		}
		arr[index] = value;
	}
}
