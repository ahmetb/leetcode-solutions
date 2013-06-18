public class Solution {
    // http://leetcode.com/onlinejudge#question_33
    public int search(int[] A, int target) {
        int lo = 0, hi = A.length-1;
        
        int first = A[0];
        int last = A[A.length-1];
        
        while(A.length > 1 && lo < hi){
            int med = (hi + lo)/2;
            
            if (A[med] > A[hi])
                lo = med+1;
            else
                hi = med;
        }
        int smallest = lo;
        
        if (A[smallest] == target) return smallest;
        else if (target >= first){
            lo = 0;
            hi = smallest == 0 ? A.length-1 : smallest-1;
        } else { // 
            lo = smallest+1;
            hi = A.length-1;
        }   
            
        while(lo<=hi){
            int med = (hi+lo)/2;
            if (A[med] == target) return med;
            else if (A[med] < target){
                lo = med+1;
            } else {
                hi = med-1;
            }
        }
        return -1;
    }
}