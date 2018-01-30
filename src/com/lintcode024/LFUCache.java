package com.lintcode024;

/**
 * 24. LFU缓存
 * @author sumuxi
 *
 */
public class LFUCache {

	public static void main(String[] args) {
		LFUCache l = new LFUCache(3);
		l.set(2,2);
		l.set(1,1);
		System.out.println(l.get(2));
		System.out.println(l.get(1));
		System.out.println(l.get(2));
		l.set(3,3);
		l.set(4,4);
		System.out.println(l.get(3));
		System.out.println(l.get(2));
		System.out.println(l.get(1));
		System.out.println(l.get(4));
	}
	
	private java.util.ArrayList<Integer> keys;
	private java.util.ArrayList<Integer> values;
	private java.util.ArrayList<Integer> freq;//Frequency
	private int capacity;//总容量
	private int size;//当前的容量
	
	/**初始化
	 * @param capacity: An integer
	 */
	public LFUCache(int capacity) {
		this.capacity = capacity;
		size = 0;
		keys = new java.util.ArrayList<Integer>();
		values = new java.util.ArrayList<Integer>();
		freq = new java.util.ArrayList<Integer>();
    }

    /**
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
    	//认为 key 合法
    	int i;
    	if (( i= keys.indexOf(new Integer(key))) >= 0) {
			values.set(i, value);
//			freq.set(i, 0);
			return;
		}
    	
    	if (size<capacity) {//还有位置
    		keys.add(key);
    		values.add(value);
    		freq.add(0);
        	size++;
		}else {//size>=capacity
			int index = min(freq);
			keys.set(index, key);
			values.set(index, value);
			freq.set(index, 0);
		}
    }

    private int min(java.util.ArrayList<Integer> freq) {
    	Integer min = Integer.MAX_VALUE;
    	int index = -1;
    	for (int i=0; i<freq.size(); i++) {
			if (freq.get(i)<min) {
				min = freq.get(i);
				index = i;
			}
		}
    	
    	return index;
	}

	/**
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
    	int index = keys.indexOf(new Integer(key));
    	if (index==-1) {//没有key
			return -1;
		}else {//有key
			freq.set(index, freq.get(index) + 1);
			return values.get(index);
		}
    }

}
