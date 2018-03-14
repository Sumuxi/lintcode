package com.lintcode013;

/**13. 字符串查找,AC
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		
	}
	
	/**JDK自带KMP算法，O(n)
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr1(String source, String target) {
        // write your code here
        if(source==null||target==null){
            return -1;
        }
        return source.indexOf(target);
    }
    
    /**蛮力方法，O(n2);
     * @param source
     * @param target
     * @return
     */
    public int strStr(String source, String target) {
        if(source==null||target==null){
            return -1;
        }
        if(source.length()<target.length()){
        	return -1;
        }
        
        for (int i = 0; i<=source.length()-target.length(); i++) {
			int j,k;
        	for (j=i,k=0; k<target.length(); j++,k++) {
				if (source.charAt(j)!=target.charAt(k)) {
					break;
				}
			}
			if (k==target.length()) {
				return i;
			}
		}
        return -1;
    }
}
