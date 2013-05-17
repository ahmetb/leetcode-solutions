public class Solution {
    // SearchForARange
    // http://leetcode.com/onlinejudge#question_34
    public int[] searchRange(int[] A, int target) {
        int lo = 0, hi = A.length-1, med;
        
        int pos = -1;
        
        while (hi >= lo){
            med = (hi+lo)/2;
            int val = A[med];
            
            if (val == target){
                pos = med;
                break;
            } else if (val < target){
                lo = med+1;
            } else { // val > target
                hi = med-1;
            }
        }
        
        // from `pos` search to left
        int left = pos;
        while (left > 0){
            if (A[left-1] == target) left--;
            else break;
        }
        
        // from `pos` search to right
        int right = pos;
        while (right <= A.length-2 && pos >= 0){
            if (A[right+1] == target) right++;
            else break;
        }
    
        return new int[]{left, right};
    }
}