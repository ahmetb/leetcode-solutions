import java.util.*;

public class Solution {

    private java.util.HashMap<String, Integer> cache;


    // #120 Triangle
    // http://leetcode.com/onlinejudge#question_120
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        cache = cache = new java.util.HashMap<String, Integer>();
        if (triangle == null || triangle.isEmpty()) return 0;

        return minimumTotal(triangle,0,0);
    }

    private int minimumTotal(ArrayList<ArrayList<Integer>> t, int ri, int rj){
        String key = ri+","+rj;
        
        if (cache.containsKey(key))
            return cache.get(key);
        

        if (ri == t.size() - 1) { // bottom line of triangle
            return t.get(ri).get(rj);
        } else {
            int res = t.get(ri).get(rj) + Math.min(minimumTotal(t, ri+1, rj), minimumTotal(t, ri+1, rj+1));
            cache.put(key,res);
            return res;
        }       
    }
}