package com.lintcode180;

/**180. 二进制表示
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	private int meizuochulai;
	
	/**
     * @param n: Given a decimal number that is passed in as a string
     * @return: A string
     */
	public String binaryRepresentation(String n) {
    	String[] str = n.split("\\.");
    	boolean hasDot;
    	if(str.length==1){//没有小数点
    		hasDot = false;
    	}else /*if(str.length==2)*/ {//有小数点
    		hasDot = true;
		}
    	if(hasDot&&str[1].length()>0&& !(str[1].endsWith("0")||str[1].endsWith("5")) ){//有小数且不是0或者5结尾
    		return "ERROR";
    	}
    	
    	int sign = 1;
    	int i = 0;
    	if(str[0].charAt(0)=='-'){
    		sign = -1;
    		i++;
    	}else if(str[0].charAt(0)=='+'){
			sign = 1;
			i++;
		}
    	long p1 = 0;
    	while(i<str[0].length()){
    		p1 = p1*10+str[0].charAt(i++)-'0';
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append(Long.toBinaryString(sign*p1));
    	
    	if( hasDot ){
    		double p2 = Double.parseDouble(str[1]);
        	if(p2>0){
        		StringBuilder sb1 = new StringBuilder();
            	while(!Double.isNaN(p2-0.0)){
            		p2= p2*2;
            		if(Double.isNaN(p2-1)){
            			sb1.append('1');
            			p2 = p2-1;
            		}else
            			sb1.append('0');
            		if(sb1.length()>32){
            			return "ERROR";
            		}
            	}
            	sb.append("."+sb1.toString());
        	}
    	}
    	return sb.toString();
    }
    
}
