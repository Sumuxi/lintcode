package com.lintcode012;

/**12. 带最小值操作的栈 ,AC
 * 
 * @author sumuxi
 *
 */
public class MinStack3 {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * 思路：使用两个栈，一个存数值的栈和一个存当前最小值的辅助栈,
	 * 		每次数值栈压栈时，辅助栈压入当前最小值,
	 * 		每次数值栈出栈时，辅助栈弹出当前最小值
	 */
	
	java.util.ArrayList<Integer> data;// 数值栈
	/*
	 * 增加一个辅助栈（用于存放数据栈之前最小的元素与新压入栈元素之间的较小值）
	 */
	java.util.ArrayList<Integer> mins;// 辅助栈
	public MinStack3() {
        // do intialization if necessary
		data = new java.util.ArrayList<Integer>();
		mins = new java.util.ArrayList<Integer>();
    }

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
    	data.add(number);//在表的末尾添加
    	/*if(mins.size()==0){
    		mins.add(number);
    	}else {//mins.size()>0
			if (number<=mins.get(mins.size()-1)) {
				mins.add(number);
			}else {
				mins.add(mins.get(mins.size()-1));
			}
		}*/
    	/*
    	 * 压入 min(number, mins.get(mins.size()-1))
    	 */
    	if(mins.size()==0 || number<=mins.get(mins.size()-1))
    		mins.add(number);
    	else
    		mins.add(mins.get(mins.size()-1));
    }

    /**
     * @return: An integer
     */
    public int pop() {
        // write your code here
    	mins.remove(mins.size()-1);//也出栈
    	return data.remove(data.size()-1);//移除表中末尾的元素
    }

    /**
     * @return: An integer
     */
    public int min() {
    	return mins.get(mins.size()-1);
    }
}
