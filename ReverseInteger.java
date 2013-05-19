public class Solution {
    // Reverse integer (doesn't handle overflows)
    // http://leetcode.com/onlinejudge#question_7
    public int reverse(int x) {
        int sign = (x < 0) ? -1 : 1;
        if (x < 0) x = -x;
        
        int y = x;
        int r = 0;
        while (y > 0){
            int d = y % 10;
            y /= 10;
            
            r *= 10;
            r += d;
        }
        return r*sign;
    }
}