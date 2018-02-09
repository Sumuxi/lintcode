package com.lintcode421;

/**421. 简化路径
 * 挑战：你是否考虑了 路径 = "/../" 的情况？
		在这种情况下，你需返回"/"。
		此外，路径中也可能包含双斜杠'/'，如 "/home//foo/"。
		在这种情况下，可忽略多余的斜杠，返回 "/home/foo"。
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().simplifyPath("////////"));
	}
	
	/**
     * @param path: the original path
     * @return: the simplified path
     */
	public String simplifyPath(String path) {
        path = path.replaceAll("/{2,}", "/");
        if(!path.endsWith("/")){
        	path = path+"/";
        }
        java.util.ArrayList<String> stack = new java.util.ArrayList<String>();
        for (int i = 0; i < path.length(); ) {
			int j=i;
			while (j<path.length()&&path.charAt(j)!='/') {
				j++;
			}
			String t = path.substring(i, ++j);
			i=j;
			if(t.equals("./")){
				continue;
			}
			if(t.equals("../")){
				if(stack.size()>1)
				    stack.remove(stack.size()-1);
				continue;
			}
			stack.add(t);
		}
        if(stack.size()==1)
        	return stack.get(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size()-1; i++) {
			sb.append(stack.get(i));
		}
        String last = stack.get(stack.size()-1);
        sb.append(last.substring(0,last.length()-1));
        return sb.toString();
    }
	
}
