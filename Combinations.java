public class Solution {
    // Combinations
    // http://leetcode.com/onlinejudge#question_77
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // I saw that n < 32 (in fact <=13), so I'll generate all ints 0..2^n-1
        // if set bits == k then it's a valid combination.
        // these ints are bitmaps indicates existance of elements in combination
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (k == 0) return result;
        
        for(int i = 0; i < (1<<n); i++){
            // count bits in i
            int j = i;
            int c = 0;
            while (j != 0){
                if ((j & 1) == 1) c++;
                j = j>>1;
            }
            
            if (c == k){
                // strip bits again
                ArrayList<Integer> comb = new ArrayList<Integer>(k);
                
                int ind = 0;
                j = i;
                while (j != 0){
                    if ((j & 1) == 1) comb.add(ind+1);
                    j = j>>1;
                    ind++;
                }
                result.add(comb);
            }
        }
        return result;
    }
}