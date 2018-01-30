package com.lintcode012;

/**12. 带最小值操作的栈 ,AC,但是min()方法不是O(1)的
 * @author sumuxi
 *
 */
public class MinStack2 {
	
	public static void main(String[] args) {
		
	}
	
	java.util.ArrayList<Integer> list;
	public MinStack2() {
        // do intialization if necessary
		list = new java.util.ArrayList<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
    	list.add(number);//在表的末尾添加
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
    	return list.remove(list.size()-1);//移除表中末尾的元素
    }

    /*
     * @return: An integer
     */
    public int min() {
    	if (list.size()==0) {
			throw new RuntimeException("MinStack.list.size()==0");
		}
    	int min = Integer.MAX_VALUE;
    	for (int i=0; i<list.size(); i++) {
			if (list.get(i)<min) {
				min = list.get(i);
			}
		}
    	return min;
    }
}
