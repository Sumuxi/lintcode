package com.lintcode012;

/**12. 带最小值操作的栈 ,AC
 * 将栈值都存为与当前最小值的差,这样不在需要辅助栈,但增加了一些计算
 * @author sumuxi
 *
 */
public class MinStack4 {
	
	public static void main(String[] args) {
		
	}
	
	java.util.ArrayList<Integer> data;//数值栈
	int min;
	public MinStack4() {
		data = new java.util.ArrayList<Integer>();
    }

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
    	if (data.isEmpty()) {
			data.add(0);
			min = number;
		}else {
			int t;
			if ((t=number-min)<0) {
				//遇到了比当前最小值更小的数
				min = number;
			}
			data.add(t);
		}
    }

    /**
     * @return: An integer
     */
    public int pop() {
    	int tail = data.size()-1;
    	if(data.get(tail)<0){
    		min -= data.get(tail);
    	}
    	return min + data.remove(tail);
    }

    /**
     * @return: An integer
     */
    public int min() {
    	if (data.size()==0) {
			throw new RuntimeException("MinStack.data.size()==0");
		}
    	return min;
    }
}
