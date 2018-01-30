package com.lintcode133;

import java.util.List;

/**133. 最长单词
 * 挑战：遍历两次的办法很容易想到，如果只遍历一次你有没有什么好办法？
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    public List<String> longestWords(String[] dictionary) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dictionary.length; i++) {
			if(dictionary[i].length()>=max){
				if(dictionary[i].length()>max){
					max = dictionary[i].length();
					list.clear();
				}
				list.add(i);
			}
		}
        java.util.ArrayList<String> result = new java.util.ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
			result.add(dictionary[list.get(i)]);
		}
        return result;
    }
    
}
