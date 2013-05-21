public class Solution {
    // Search Insert Position
    // http://leetcode.com/onlinejudge#question_35
    public int searchInsert(int[] A, int target) {
        int lo = 0, hi = A.length-1;
        int res = -1;
        while (lo <= hi){
            int med = (hi+lo)/2;
            int val = A[med];
            
            
            if (val < target)
                lo = med + 1;
            else if (val > target)
                hi = med - 1;
            else {
                res = med;
                break;
            }
        }
        if (res < 0) res = lo;
        return res;
    }
}