public class Solution {
    // http://leetcode.com/onlinejudge#question_31
    public void nextPermutation(int[] num) {
        for(int i = num.length - 1; i >= 0; i--){
            for(int j = i - 1; j >= 0; j--){
                if (num[j] < num[i]){
                    // swap i<->j, sort after j
                    int tmp = num[j];
                    num[j] = num[i];
                    num[i] = tmp;
                    
                    Arrays.sort(num, j + 1, num.length);
                    return;
                }
            }
        }
        Arrays.sort(num); // already at last permutation
    }
}