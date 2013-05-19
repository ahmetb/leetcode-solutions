public class Solution {
    // Remove Duplicates from Sorted Array - II
    // http://leetcode.com/onlinejudge#question_26
    public int removeDuplicates(int[] A) {
        int wrI = 0;
        Integer prevVal = null;
        Integer prevPrevVal = null;
        for(int i = 0; i < A.length; i++){
            Integer val = A[i];

            if (!val.equals(prevVal) || !prevVal.equals(prevPrevVal)){
                A[wrI++] = val;
            }
            prevPrevVal = prevVal;
            prevVal = val;
        }
        return wrI;
    }
}