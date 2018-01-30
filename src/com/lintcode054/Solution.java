package com.lintcode054;

/**54. 转换字符串到整数
 * 挑战：null
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution());
	}
	
	/**解析字符串为整数
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        if (str==null) {//如果没有合法的整数，返回0
        	return 0;
		}
        str = str.trim();
        if (str.equals("")) {
			return 0;
		}
        
        int radix = 10;
        int index = 0;
        int result = 0;
        
        //解析正负符号
        char ch = str.charAt(0);
        
        if(ch=='-'){
        	index++;
        	
        	int temp;
            while (index<str.length()) {
    			ch = str.charAt(index++);
            	if(ch>='0'&&ch<='9'){
            		if((temp=result*radix - (ch-'0'))>0){//利用溢出的特性
            			return Integer.MIN_VALUE;
            		}
            		result = temp;
            	}else {//非法字符
    				break;
    			}
    		}
            return result;
            
        }else if(ch=='+'){
        	index++;
        }
        
        int temp;
        while (index<str.length()) {
			ch = str.charAt(index++);
        	if(ch>='0'&&ch<='9'){
        		if((temp=result*radix + (ch-'0'))<0){//利用溢出的特性
        			return Integer.MAX_VALUE;
        		}
        		result = temp;
        	}else {//非法字符
				break;
			}
		}
        return result;
    }
	
	/**解析字符串为整数,使用了 long 型变量存储临时值,不可取
     * @param str: A string
     * @return: An integer
     */
    public int atoi1(String str) {
        if (str==null) {//如果没有合法的整数，返回0
        	return 0;
		}
        str = str.trim();
        if (str.equals("")) {
			return 0;
		}
        
        int radix = 10;
        int index = 0;
        long a = 0;//整数部分
//        double b = 0.0;//小数部分
        char ch = str.charAt(0);
        
        //解析正负符号
        int prefix;
        if(ch=='-'){
        	index++;
        	prefix = -1;
        }else if(ch=='+'){
        	index++;
        	prefix = 1;
        }else{
        	prefix = 1;
        }
        
//        boolean flag = false;//是否有小数点
        
        while (index<str.length()) {
			ch = str.charAt(index++);
        	if(ch>='0'&&ch<='9'){
        		a = a*radix + ch-'0';
        		if(a>2147483648l){
        			break;
        		}
        	}else {//非法字符
				break;
				// return 0;
			}
		}
        
//        if (flag) {
//			double r = 0.1;
//			int index2 = str.length()-1;
//			while (index2>index) {
//				ch = str.charAt(index2--);
//	        	if(ch>='0'&&ch<='9'){
//	        		b = b*r + r*(ch-'0');
//	        		
//	        	}else {//非法字符，返回0
//					return 0;
//				}
//			}
//		}
        
        a = prefix*a;
        if (a>2147483647) {
			return 2147483647;
		}
        if (a<-2147483648) {
        	return -2147483648;
        }
        return (int)a;
    }
	
}
