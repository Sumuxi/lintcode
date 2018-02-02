package com.lintcode156;

import java.util.List;

/**156. 合并区间 
 * 挑战：O(n log n) 的时间和 O(1) 的额外空间。
 * @author sumuxi
 *
 */
public class Solution {
    
	/**先排序，在合并区间，思路比较简单
     * @param intervals: interval list.
     * @return: A new interval list.
     */
	public List<Interval> merge(List<Interval> intervals) {
    	if(intervals.size()==1)
        	return intervals;
    	
    	java.util.Collections.sort(intervals, new java.util.Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start<o2.start)
					return -1;
				else if (o1.start>o2.start) {
					return 1;
				}else {
					return 0;
				}
			}
    		
    	});
        
    	int s = 0;
    	for (int i = 0; i<intervals.size();) {
    		int j = i+1;
    		while (j<intervals.size()&&intervals.get(i).end>=intervals.get(j).end) {
    			j++;
    		}
    		//intervals.get(i).end>=intervals.get(j).end
    		if(j==intervals.size()){
    			intervals.set(s++, intervals.get(i));
    			break;
    		}
    		//intervals.get(i).end<intervals.get(j).end
    		if(intervals.get(i).end>=intervals.get(j).start){
    			intervals.get(j).start = intervals.get(i).start;
    		}else {
    			intervals.set(s++, intervals.get(i));
			}
    		i=j;
		}
    	while (s<intervals.size()) {
    		intervals.remove(intervals.size()-1);
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
 * }
 */
class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}