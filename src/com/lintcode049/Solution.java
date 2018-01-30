package com.lintcode049;

/**49. 字符大小写排序
 * 挑战：在原地扫描一遍完成
 * @author sumuxi
 *
 */
public class Solution {

	/**有点类似快排的思想，前后交换，一趟扫描完成
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        if(chars==null||chars.length == 0)
        	return;
        
        int i = 0;
        int j = chars.length-1;
        while(true){
        	while(i<chars.length&&chars[i]>='a' && chars[i]<='z'){//find upper case
        		i++;
        	}
        	while(j>=0&&chars[j]>='A' && chars[j]<='Z'){//find lower case
        		j--;
        	}
        	if(i<j){
        		char t = chars[i];
        		chars[i] = chars[j];
        		chars[j] = t;
        	}else{
        		break;
        	}
        }
    }
	
}
