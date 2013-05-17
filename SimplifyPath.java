import java.util.*;

public class Solution {
    // Simplify Path
    // http://leetcode.com/onlinejudge#question_71
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<String> paths = new Stack<String>();

        if (path != null){
            StringTokenizer st = new StringTokenizer(path, "/");
            
            while(st.hasMoreTokens()){
                String tok = st.nextToken();
                
                if (tok == null || tok.length() == 0) continue;
                if (".".equals(tok)) continue;
                if (("..").equals(tok)){
                    // go up one dir if possible
                    if (!paths.isEmpty()) paths.pop();
                } else {
                    paths.push(tok); // add to path
                }
            }    
        }
   
        StringBuilder sb = new StringBuilder();
        if (paths.isEmpty()) return "/";
        
        while(!paths.isEmpty()){
            String part = paths.pop();
            sb.insert(0, part);
            sb.insert(0, '/');
        }
        return sb.toString();
    }
}