import java.util.*;

public class Solution {
    // Subsets II
    // http://leetcode.com/onlinejudge#question_90
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<ArrayList<Integer>> ss = new Set<ArrayList<Integer>>();
        
        // assuming |nums|<=32
        for (int i = 0; i < (1<<nums.length); i++){
            int j = i;
            int n = 0;
            ArrayList<Integer> s = new ArrayList<Integer>();
            System.out.println(i);
            while(j != 0){
                if ((j & 1) == 1){
                    s.add(nums[n]);
                }
                j >>= 1;
                n++;
            }
            ss.add(s);
        }
        return new ArrayList<ArrayList<Integer>>(ss);
    }
}
