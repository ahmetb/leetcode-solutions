public class Solution {
    ArrayList<ArrayList<Integer>> result;
    
    // Permutations-II
    // http://leetcode.com/onlinejudge#question_47
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
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
            
            for(ArrayList<Integer> o : result){
                if (o.equals(l)) return;
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