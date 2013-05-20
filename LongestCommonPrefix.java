public class Solution {
    // Longest Common Prefix
    // http://leetcode.com/onlinejudge#question_14
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        int maxLen = 0;
        for(String s : strs)
            maxLen = Math.max(maxLen, s.length());
        char[] sb = new char[maxLen];
        
        int pos = 0;
        char c = 0;
        while(true){
            boolean fail = false;

            for(int i = 0 ; i < strs.length; i++){
                String s = strs[i];

                if (pos > s.length()-1){
                    fail = true;
                    break;
                }

                if (i == 0) c = s.charAt(pos);
                else if (s.charAt(pos) != c){
                    fail = true;
                    break;
                }
            }

            if (fail) break;
            //sb.append(c);
            //pos++;
            sb[pos++] = c;
        }
        return new String(sb, 0, pos);
    }   
}