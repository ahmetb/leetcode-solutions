
public class Solution {

    // Add Binary
    // http://leetcode.com/onlinejudge#question_67
    public String addBinary(String a, String b) {
        int maxlen = Math.max(a.length(), b.length());

        char[] res = new char[maxlen];

        int c = 0;
        for(int i = 0; i < maxlen ; i++){
            int ad = (i > a.length()-1) ? 0 : a.charAt(a.length()-1-i)-'0';
            int bd = (i > b.length()-1) ? 0 : b.charAt(b.length()-1-i)-'0';

            res[res.length-1-i] = (char) ((ad+bd+c)%2 + '0');
            c = (ad+bd+c>=2) ? 1 : 0;
        }

        if (c > 0)
            return "1"+new String(res);
        return new String(res);
    }
}