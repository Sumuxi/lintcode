package com.lintcode030;

import java.util.List;

/**
 * 30. 插入区间 
 * @author sumuxi
 *
 */
public class Solution {

	public static void main(String[] args) {
		List<Interval> intervals = new java.util.ArrayList<Interval>();
		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(7, 8));
		intervals.add(new Interval(10, 13));
		System.out.println(new Solution().insert(intervals, new Interval(7, 9)));
	}
	
	/**原理和 029 题很相似，可以用二分查找
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
    	if (intervals == null) {//应该不会为 null
			throw new RuntimeException("intervals == null");
		}
    	if (intervals.size()==0) {
			intervals.add(newInterval);
			return intervals;
		}
    	
    	int start = 0;
    	int end = intervals.size()-1;
    	int mid;
    	boolean flag = false;//指示二分查找中是否 头相等
    	while (start<=end) {
			mid = (start+end)/2;
			
			if (newInterval.start < intervals.get(mid).start) {//左
				end = mid-1;
			}else if (newInterval.start > intervals.get(mid).start) {//右
				start = mid+1;
			}else {
				start = mid;//很重要,统一返回start
				flag = true;//头相等
				break;
			}
		}
    	if (flag) {//头相等, start 指向头相等的那个区间
    		if (newInterval.end <= intervals.get(start).end) {
				return intervals;
			}
    		//newInterval.end > intervals.get(start).end
    		int i = start+1;
			while (i<intervals.size()&&newInterval.end>=intervals.get(i).start) {
				intervals.remove(start);//干掉start，后面的往前移动，目的是完成区间合并
//				i++;
			}
			intervals.get(start).start = newInterval.start;
			intervals.get(start).end = intervals.get(start).end>newInterval.end?
					intervals.get(start).end:newInterval.end;
			return intervals;
		}
    	
    	//start 指向应该插入的位置的索引
    	int index = start;
    	if (index == 0) {//插在表头
    		int end1 = -1;
    		while (start<intervals.size()&&newInterval.end>=intervals.get(start).start) {
				end1 = intervals.remove(start).end;//干掉start，后面的往前移动，目的是向右合并区间
			}
    		intervals.add(index, new Interval(newInterval.start, 
    						end1>newInterval.end?end1:newInterval.end));
    		
		}else if (index == intervals.size()) {//插在表尾
			if (newInterval.start <= intervals.get(start-1).end) {//向左合并区间
				intervals.get(start-1).end = newInterval.end>intervals.get(start-1).end?
						newInterval.end:intervals.get(start-1).end;
			}else {//newInterval.start > intervals.get(start-1).end
				intervals.add(index, newInterval);
			}
		}else {//表中

			int end1 = -1;
    		while (start<intervals.size()&&newInterval.end>=intervals.get(start).start) {
				end1 = intervals.remove(start).end;//干掉start，后面的往前移动，目的是向右合并区间
			}
    		
    		if (newInterval.start <= intervals.get(start-1).end) {//向左合并区间
				intervals.get(start-1).end = end1>newInterval.end?end1:newInterval.end;
			}else {//newInterval.start > intervals.get(start-1).end
				intervals.add(index, new Interval(newInterval.start, 
						end1>newInterval.end?end1:newInterval.end));
			}
		}
    	
    	return intervals;
    }

}

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class Interval {
	int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
    	return "["+start+","+end+"]";
    }
}
