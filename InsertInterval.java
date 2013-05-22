/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {

    // Insert Interval
    // http://leetcode.com/onlinejudge#question_57
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // intervals already sorted        
        int pos = -1;
        int lo = 0, hi = intervals.size()-1;
        while (lo <= hi){
            int med = (hi+lo)/2;
            int val = intervals.get(med).start;
            
            if (val < newInterval.start)
                lo = med + 1;
            else if (val > newInterval.start)
                hi = med - 1;
            else {
                pos = med;
                break;
            }
        }
        if (pos < 0) pos = lo;
        
        // just add
        intervals.add(pos, newInterval);
        int e = newInterval.end;
        
        for(int i = 0; i < intervals.size() - 1; i++){
            Interval in = intervals.get(i);
            if (in.start > e) break; // optimization
            
            Interval next = intervals.get(i + 1);
            
            if (in.end >= next.start){
                // merge
                in.end = Math.max(in.end, next.end);
                intervals.remove(i + 1);
                i--;
            }
        }
        return intervals;
    }
}