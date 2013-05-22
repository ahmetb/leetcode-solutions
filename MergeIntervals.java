/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution implements Comparator<Interval> {
    // Merge Intervals -- complexity O(nlogn) since intervals are not sorted
    // http://leetcode.com/onlinejudge#question_56
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Sort intervals according to .start values
        Collections.sort(intervals, this);
        
        ArrayList<Interval> merged = new ArrayList<Interval>();
        
        int s = -1, e = -1;
        for(Interval i : intervals){
            if (s == -1){
                // first interval
                s = i.start;
                e = i.end;
            } else {
                // remaining intervals
                if (i.start <= e){
                    // merge
                    e = Math.max(e, i.end);
                } else {
                    // push existing, update vars
                    merged.add(new Interval(s,e));
                    
                    s = i.start;
                    e = i.end;
                }
            }
        }
        if (s != -1) merged.add(new Interval(s,e));
        
        return merged;
    }
    
    public int compare(Interval i1, Interval i2){
        return i1.start - i2.start;
    }
}