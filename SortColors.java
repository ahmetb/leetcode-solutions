public class Solution {
    // Sort Colors
    // http://leetcode.com/onlinejudge#question_75
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] f = new int[3];
        for(int i = 0; i < A.length; i++){
            f[A[i]]++;
        }
        
        int j = 0;
        while(f[0]+f[1]+f[2] != 0){
            int i = f[0] != 0 ? 0 : f[1] != 0 ? 1 : 2;
            f[i]--;
            A[j++] = i;
        }
    }
}