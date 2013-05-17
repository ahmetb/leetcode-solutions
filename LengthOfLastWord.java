public class Solution {
    // length of last word
    // http://leetcode.com/onlinejudge#question_58
    public int lengthOfLastWord(String s) {
        int wlen = 0, prevwlen = 0;
        boolean wasprevspace = false;
        for(int i = 0 ; i < s.length(); i++){
            if (s.charAt(i) == ' ') {
                if (!wasprevspace){
                    prevwlen = wlen;
                    wlen = 0;
                    wasprevspace = true;
                }
            } else {
                wlen++;
                prevwlen=0;
                wasprevspace = false;
            }
        }       
        return Math.max(prevwlen, wlen);
    }
}