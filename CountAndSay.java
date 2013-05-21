public class Solution {
    // Count and Say
    // http://leetcode.com/onlinejudge#question_38
    public String countAndSay(int x) {
        StringBuilder s = new StringBuilder("1");
        for(int i = 1; i < x; i++){
            StringBuilder sb = new StringBuilder();
            
            char p = s.charAt(0);
            int n = 1;
            for(int j = 1; j < s.length(); j++){
                char c = s.charAt(j);
                
                if (c == p){
                    n++;
                } else {
                    sb.append(n);
                    sb.append(p);
                    p = c;
                    n = 1;
                }
            }
            if (n > 0){
                sb.append(n);
                sb.append(p);
            }
            s = sb;
        }
        return s.toString();
    }
}