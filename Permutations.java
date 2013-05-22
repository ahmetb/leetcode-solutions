public class Solution {
    ArrayList<ArrayList<Integer>> result;
    
    // Permutations
    // http://leetcode.com/onlinejudge#question_46
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
         result = new  ArrayList<ArrayList<Integer>>();
         
         permute(num, 0);
         return result;
    }
    
    public void permute(int[] num, int index) {
        if (index == num.length){
            // stop case
            ArrayList<Integer> l = new ArrayList<Integer>(num.length);
            for(int elm : num){
                l.add(elm);
            }
            result.add(l);
        } else {
            for (int j = index; j < num.length; j++){
                // swap num[j] <--> num[index]
                int tmp = num[index];
                num[index] = num[j];
                num[j] = tmp;
                
                permute(num, index + 1);
                
                // swap back num[j] <--> num[index]
                tmp = num[index];
                num[index] = num[j];
                num[j] = tmp;
            }
        }
    }
    
    
}