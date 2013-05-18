public class Solution {

    // Permutation Sequence
    // http://leetcode.com/onlinejudge#question_60
    public String getPermutation(int n, int k) {
        // k starts from 1
        boolean[] used = new boolean[n];
        
         StringBuilder sb = new StringBuilder();
         int m = n;
         while(k != 0 && m-->0){
            int cs = fact(n-1);
            int c = 1, pos = 1;
             if (cs > 0){
                c = k/cs;
                 if(k%cs > 0) c++; // chunk to select (starts from 1)
                pos = k - (c-1)*cs; // pos in chunk (starts from 1)
            }
             
             // find c-th unmarked in used[], c starts from 1.
             int i = 0, j = 0, res = 0;
             for(boolean b : used){
                 if (!b){
                     j++;
                 }
                 if (j == c){
                     res = i;
                     break;
                 }
                 i++;
             }
             used[res] = true;
             res += 1; // convert index to order
             sb.append(res);
             
             // iterate
             k = pos;
             n--;
         }
         return sb.toString();
    }
    
    private int fact(int s){
        if (s <= 0) return 0;
        int k = 1;
        while(s > 1){
            k *= s;
            s--;
        }
        return k;
    }
}