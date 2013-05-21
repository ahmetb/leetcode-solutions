public class Solution {
    // Trapping Rain Water
    // http://leetcode.com/onlinejudge#question_42
    public int trap(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        int max = 0;
        for(int i = 0; i < A.length; i++)
            if (A[i] > A[max])
                max = i;
        
        int result = 0;
        
        int localMax = 0;
        // traverse [0..max-1]
        for(int i = 0; i < max; i++){
            if (A[i] < localMax){
                // water!
                result += localMax - A[i];
            } else {
                // new local max
                localMax = A[i];
            }
        }
        
        localMax = 0;
        // traverse [last..max+1]
        for(int i = A.length-1; i > max; i--){
            if (A[i] < localMax){
                result += localMax - A[i];
            } else 
                localMax = A[i];
        }
        return result;
    }
}