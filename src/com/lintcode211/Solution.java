package com.lintcode211;

/**211. 字符串置换
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	public static void main(String[] args) {
		System.out.println(new Solution().Permutation("abcd", "bcae"));
	}
	
	/**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
    	if(A.length()!=B.length())
    		return false;
        java.util.HashMap<Character, Integer> map1 = new java.util.HashMap<Character, Integer>();
        java.util.HashMap<Character, Integer> map2 = new java.util.HashMap<Character, Integer>();
    	for (int i = 0; i < A.length(); i++) {
    		char c1 = A.charAt(i);
			if(map1.containsKey(c1)){
				map1.put(c1, map1.get(c1)+1);
			}else {
				map1.put(c1, 1);
			}
			
			char c2 = B.charAt(i);
			if(map2.containsKey(c2)){
				map2.put(c2, map2.get(c2)+1);
			}else {
				map2.put(c2, 1);
			}
		}
    	
    	for (java.util.Iterator<java.util.Map.Entry<Character, Integer>> iterator 
    			= map1.entrySet().iterator(); iterator.hasNext();) {
    		java.util.Map.Entry<Character, Integer> entry = iterator.next();
    		//必须先判断map2.get(entry.getKey())==null
    		//因为当map2的keySet不包含entry.getKey()时, map2.get(entry.getKey())为null
    		if(map2.get(entry.getKey())==null||entry.getValue().intValue()!=
    				map2.get(entry.getKey()).intValue()){
    			return false;
    		}
		}
    	return true;
    }
    
}
