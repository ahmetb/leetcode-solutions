public class Solution {
    
    char[][] dict = new char[][]{null,null,
        new char[]{'a', 'b', 'c'},
        new char[]{'d', 'e', 'f'},
        new char[]{'g', 'h', 'i'},
        new char[]{'j', 'k', 'l'},
        new char[]{'m', 'n', 'o'},
        new char[]{'p', 'q', 'r', 's'},
        new char[]{'t', 'u', 'v'},
        new char[]{'w', 'x', 'y', 'z'}
    };
    
    // Letter Combinations of a Phone Number
    // http://leetcode.com/onlinejudge#question_17
    public ArrayList<String> letterCombinations(String digits) {
        return letterCombinations(digits, 0);
    }
    
    public ArrayList<String> letterCombinations(String digits, int start) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            res.add(""); // boyle result output mu istenir amk
            return res; 
        }
        
        
        int d = digits.charAt(start) - '0';
        
        for(char c : dict[d]){
            
            if (start < digits.length()-1){
                ArrayList<String> r = letterCombinations(digits, start + 1);
                for(String s : r){
                    res.add(c + s);
                }
            } else {
                res.add(c + "");
            }
        }
        
        return res;
    }
}