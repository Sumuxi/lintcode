package com.lintcode575;

/**575. 表达式展开
 * 挑战：你可以不通过递归的方式完成展开吗？
 * @author sumuxi
 *
 */
public class Solution {
	
	/**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        assert s!=null;
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)==']') {
				int j=stack.length()-1;
				while (stack.charAt(j)!='[') {
					j--;
				}
				//要重复的内容
				String str = stack.substring(j+1);
				stack.delete(j, stack.length());
				j--;
				while (j>=0&&stack.charAt(j)>='0'&&stack.charAt(j)<='9') {
					j--;
				}
				//要重复的次数
				int n = Integer.parseInt(stack.substring(++j));
				stack.delete(j, stack.length());
				for (int k=0; k<n; k++) {
					stack.append(str);
				}
			}else {
				stack.append(s.charAt(i));
			}
		}
        return stack.toString();
    }
    
}
