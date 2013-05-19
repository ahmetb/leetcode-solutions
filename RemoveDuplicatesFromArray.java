public class Solution {
    // Remove Duplicates from Sorted Array
    // http://leetcode.com/onlinejudge#question_26
    public int removeDuplicates(int[] A) {
        int wrI = 0;
        Integer prevVal = null;
        for(int i = 0; i < A.length; i++){
            Integer val = A[i];
            
            if (!val.equals(prevVal)){
                A[wrI++] = val;
            }
            prevVal = val;
        }
        return wrI;
    }
}