package com.lintcode417;

/**417. 有效数字
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println();
	}
	
	/**
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
    	s = s.trim();//去除头和为的空格，这很重要
    	if(s.length()==0)	 return false;
    	int i = 0;
    	boolean hasOneDot = false;//是否已经有小数点了
    	boolean hasE = false;//是否已经有e|E了
    	if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
    		i++;
    	}else if (s.charAt(i)=='+'||s.charAt(i)=='-') {
			i++;
    		if(i==s.length())//只有一个'+'or'-'
				return false;
		}else if(s.charAt(i)=='.'){
    		hasOneDot = true;
    		i++;
    		//只有一个'.'or'.'后不为数字
    		if(i==s.length()||!(s.charAt(i)>='0'&&s.charAt(i)<='9'))
    			return false;
    	}else {//其他字符
    		return false;
		}
    	--i;
    	while(++i<s.length()) {
    		char ch = s.charAt(i);
    		if(ch>='0'&&ch<='9'){//是数字
    			continue;
    		}
    		if(ch=='.'){//是小数点
    			if (hasOneDot) {//之前已经有小数点了
    				return false;
    			}
				hasOneDot=true;
				if(i==1){
					if(s.charAt(0)=='+'||s.charAt(0)=='-'){
						if(s.length()==2)//"+."or"-."
							return false;
						if(!(s.charAt(2)>='0'&&s.charAt(2)<='9'))//"+."or"-."后不为数字
							return false;
					}else if(!(s.charAt(0)>='0'&&s.charAt(0)<='9'))//'.'前不为数字
						return false;
				}else if(i==s.length()-1){
					//'.'前不为数字
					if(!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9'))
						return false;
				}else {
					//'.'前不为数字或'.'后不为数字
					if(!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9')
							||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'))
						return false;
				}
				continue;
    		}
    		if(ch=='e'||ch=='E'){//是e
    			if(hasE){
    				return false;
    			}
    			hasE = true;
    			//'e'出现在开头或结尾处
    			if(i==0||i+1==s.length())
    				return false;
    			//'e'前不为数字或'e'后不为数字
    			if(!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9')
						||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'))
					return false;
				continue;
    		}
    		//其他情况
    		return false;
		}
    	return true;
    }
	
}
