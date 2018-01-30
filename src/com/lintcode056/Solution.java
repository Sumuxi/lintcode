package com.lintcode056;

/**56. 两数之和
 * 挑战：Either of the following solutions are acceptable:
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		int[] result = new Solution().twoSum(new int[]{1,0,-1}, 0);
		System.out.println(result[0]+" "+result[1]);
		
	}
	
	/**解法1：暴力O(n2)时间复杂度求解
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum1(int[] numbers, int target) {
    	//一定有一组答案
    	int[] result = new int[2];
    	for(int i=0; i<numbers.length-1; i++){
    		for (int j = i+1; j < numbers.length; j++) {
				if (numbers[i]+numbers[j]==target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
    	}
    	return null;
    }
	
    public int[] twoSum(int[] numbers, int target) {
    	//题目说 保证有且仅有一组解，这个信息很有用
    	java.util.HashMap<Integer, Integer> map =//(numbers[i],index)
    			new java.util.HashMap<Integer, Integer>();
    	for(int i=0; i<numbers.length; i++){
    		map.put(numbers[i], i);
    	}
    	int[] result = new int[2];
    	for(int i=0; i<numbers.length-1; i++){
//    		if (numbers[i] == target) {
//				continue;
//			}
    		Integer t = target - numbers[i];
    		if (map.containsKey(t)) {
				result[0] = i;
				result[1] = map.get(t);
				break;
			}
    		
    	}
    	return result;
    }
    
}
