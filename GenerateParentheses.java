public class Solution {

    // Generate Parentheses
    // http://leetcode.com/onlinejudge#question_22    
    public ArrayList<String> generateParenthesis(int n) {
        return generateParenthesis("", n, 0);
    }
    
    private ArrayList<String> generateParenthesis(String in, int n, int o) {
        ArrayList<String> res = new ArrayList<String>();
        
        // '(', if possible
        if (n > 0){
            res.addAll(generateParenthesis(in+"(", n - 1, o + 1));
        }
        
        // ')' if possible
        if (o > 0){
            res.addAll(generateParenthesis(in+")", n, o - 1));
        }
        
        if (n == 0 && o == 0){
            res.add(in);
        }
        return res;
    }
}