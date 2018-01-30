package com.lintcode128;

/**128. 哈希函数
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(new Solution().hashCode("abcd".toCharArray(), 100));
	}
	
	/**主要是要考虑会不会溢出的问题,利用取模运算的性质来防止溢出
	 * (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33 + ascii(d)) % HASH_SIZE
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
    	if(key==null||key.length==0)
    		return 0;
    	
    	long t = 0;
    	for (int i = 0; i < key.length; i++) {
			t = ((t%HASH_SIZE*33%HASH_SIZE)%HASH_SIZE+key[i]%HASH_SIZE)%HASH_SIZE;
		}
    	return (int)t;
    }
    
}
