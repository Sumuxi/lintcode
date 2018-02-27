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

	/**排序思想，先排序再取数，有较大冗余，因为只要前k大元素
	 * 使用库函数中的快排方法，AC
	 * @param k
	 * @param nums
	 * @return
	 */
	public static int kthLargestElement2(int k, int[] nums) {
		// write your code here
		java.util.Arrays.sort(nums);
		return nums[nums.length - k];
	}

	/**近似于插入排序思想,TLE
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
	
	/**插入排序思想,TLE
	 * @param k
	 * @param nums
	 * @return
	 */
	public static int kthLargestElement5(int k, int[] nums) {
		// write your code here
		int[] arr = new int[k];//保存前K大数的数组
		for (int i = 0; i < nums.length; i++) {
			int j = 0;
			while(j<k&&nums[i]>arr[j]){
				if(j>0)
					arr[j-1] = arr[j];
				j++;
			}
			if(j>0)
				arr[j-1] = nums[i];
		}
		return arr[0];
	}
	
	/**使用堆，建立一个最小堆来存储前K大元素
	 * @param k
	 * @param nums
	 * @return
	 */
	public static int kthLargestElement6(int k, int[] nums) {
		assert k>0;
		int[] heap = new int[k+1];//0位置空着
		int j=1;
		for (int i = 0; i < k; i++) {
			heap[j++] = nums[i];
		}
		buildMinHeap(heap);
		for (int i = k; i < nums.length; i++) {
			if(nums[i]>heap[1]){
				heap[1] = nums[i];
				minHeapify(heap, 1);
			}
		}
		return heap[1];
	}

	//建立最小堆
	private static void buildMinHeap(int[] heap) {
		for (int i=heap.length>>>1; i>0; i--) {
			minHeapify(heap,i);
		}
	}

	//维持最小堆的性质
	private static void minHeapify(int[] heap, int p) {
		int l = p<<1;
		int r = (p<<1)|0x01;
		int smallest = p;
		if(l<heap.length&&heap[l]<heap[p]){
			smallest = l;
		}
		if(r<heap.length&&heap[r]<heap[smallest]){
			smallest = r;
		}
		if(smallest!=p){
			int t = heap[p];
			heap[p] = heap[smallest];
			heap[smallest] = t;
			minHeapify(heap, smallest);
		}
	}
	
	/**快排的思想，准确说应该是划分的思想
	 * @param k
	 * @param nums
	 * @return
	 */
	public static int kthLargestElement3(int k, int[] nums) {
		int left = 0;
		int right = nums.length-1;
		int i = partition(nums, left, right);
		k--;
		while (i!=k) {
			if(i>k){
				right = i-1;//减小右边界
				i = partition(nums, left, right);
			}else {//i<k
				left = i+1;//增大左边界
				i = partition(nums, left, right);
			}
		}
		return nums[i];
	}

	private static int partition(int[] nums, int left, int right) {
		int pivot = nums[right];
		int i = left;
		//把比枢纽大的值全放在左边
		for (int j=left; j<right; j++) {
			if(nums[j]>=pivot){
				int t = nums[i];
				nums[i++] = nums[j];
				nums[j] = t;
			}
		}
		nums[right] = nums[i];
		nums[i] = pivot;
		return i;
	}

}
