package com.lintcode032;

/**
 * 32. 最小子串覆盖
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {

		System.out.println(new Solution()
				.minWindow("aaaaaaaaaaaaaaaaaaabbbbbbbbbdfadsfjalsdjfalsdjfsadfadf", "aaaaaabbbbbbbbbdfjaldjf") );
	}

	private int size = 0;
	
	/** 默认字母是大小写敏感的,而且目标串中重复的字母,也是要重复计算的
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        if(source==""||target==""){
            return "";
        }
        
        //默认字母是大小写敏感的
        java.util.ArrayList<letter> set = new java.util.ArrayList<letter>();
        for (int i = 0; i < target.length(); i++) {
			set.add(new letter(target.charAt(i), false));
		}
        
        if (source.length()<set.size()) {
			return "";
		}
        
        //去掉前后没用的字符
        int start = 0;
    	while (start<source.length()&&!contain(set, source.charAt(start))) {
			start++;
		}
    	this.size = 0;
		clearFlag(set);
    	int end = source.length()-1;
    	while (end>0&&!contain(set, source.charAt(end))) {
			end--;
		}
    	this.size = 0;
		clearFlag(set);
    	if (start>end||end-start+1<set.size()) {
			return "";
		}
    	
    	java.util.ArrayList<String> list = new java.util.ArrayList<String>(); 
        int index;
        for (int i=start; i<=end-set.size()+1; i++) {//加 1 是因为 会出现 end-start+1 == set.size();
        	index = i;
        	while (index<=end) {
        		contain(set, source.charAt(index++));
				if (this.size==set.size()) {
					list.add(source.substring(i, index));
					break;
				}
			}
			this.size = 0;
			clearFlag(set);
		}
        if (list.size()==0) {
			return "";
		}
//        System.out.println(list);
        return java.util.Collections.min(list, new java.util.Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if (s1.length()<s2.length()) {
					return -1;
				}else if (s1.length()>s2.length()) {
					return 1;
				}else {
					return 0;
				}
			}
			
		});
    }

	private void clearFlag(java.util.ArrayList<letter> set) {
		for (letter letter : set) {
			letter.flag = false;
		}
		
	}

	private boolean contain(java.util.ArrayList<letter> set, char ch) {
		for (letter letter : set) {
			if (letter.ch==ch&&!letter.flag) {
				letter.flag = true;
				this.size++;
				return true;
			}
		}
		return false;
	}
}

class letter{//字母类
	char ch;//字母
	boolean flag;//是否被访问过
	
	public letter(char ch, boolean flag) {
		super();
		this.ch = ch;
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "("+ch+","+flag+")";
	}
}