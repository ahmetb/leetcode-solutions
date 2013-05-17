public class Solution {
    // Search 2d Matrix
    // http://leetcode.com/onlinejudge#question_74
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // binary search in first elements of a row
        int lowi = 0, highi = m-1;
        int resi = -1;
        while(lowi <= highi){
            int med = (highi+lowi)/2;
            int medVal = matrix[med][0];
            if (medVal == target){
                return true;
            } else if (medVal < target){
                lowi = med+1;
            } else { // medVal > target
                highi = med-1;
            }
        }
        if (resi == -1) resi = Math.min(m-1, highi); // highi indicates insertion point-1
        if (resi < 0) resi = 0;
        
        // resi indicates which row number might be in
        
        // trivial binary search 
        int lo = 0, hi = n-1;
        while(lo <= hi){
            int med = (hi+lo)/2;
            int mVal = matrix[resi][med];
            if (mVal == target) return true;
            else if (mVal < target){
                lo = med+1;
            } else {
                hi = med-1;
            }
        }
        return false;
    }
}