import java.util.*;

public class Solution {
    // Subsets
    // http://leetcode.com/onlinejudge#question_78
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> sets = new  ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < Math.pow(2,S.length); i++){
            // strip bits of i to figure out if element S[k] exists in this set
            ArrayList<Integer> set = new ArrayList<Integer>();
            
            int j = i;
            int k = 0;
            while (j != 0){
                if ((j & 1) > 0)
                    set.add(S[k]);
                
                k++;
                j >>= 1;
            }
            
            sets.add(set);
        }
        return sets;
    }
}
