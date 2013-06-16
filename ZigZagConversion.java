public class Solution {
    // http://leetcode.com/onlinejudge#question_6
    public String convert(String s, int nRows) {
        if (nRows == 1) return s;
        
        char[][] cs = new char[nRows][s.length()]; // redundant
        
        int mode = 0; // 0 == up-->down, 1 == to right & up
        
        int row = 0, col = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            cs[row][col] = c;
            
            if (row == nRows - 1)
                mode = 1;
            else if (row == 0)
                mode = 0;
                
            if (mode == 0){
                row++;
            } else if (mode == 1){
                row--;
                col++;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            char[] rw = cs[i];
            for(char c : rw){
                if (c != 0) sb.append(c);
            }
        }
        return sb.toString();
    }
}