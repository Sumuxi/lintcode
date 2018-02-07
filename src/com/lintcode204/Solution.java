package com.lintcode204;

/**204. 单例
 * 挑战：如果并发的调用 getInstance，你的程序也可以正确的执行么？
 * @author sumuxi
 *
 */
public class Solution {
    
	private static Solution s = new Solution();
    /**单例的两种写法; 方式一(更简单常用一些)
     * @return: The same instance of this class every time
     */
    public static Solution getInstance1() {
        return s;
    }
	
    private static Solution s1;
    //方式二
    public static Solution getInstance() {
    	if(s1==null){
    		synchronized (Solution.class) {
    			if(s1==null)
    				s1 = new Solution();
    		}
    	}
    	return s1;
    }
    
}
