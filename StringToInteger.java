public class Solution {
    // String to Integer (atoi)
    // http://leetcode.com/onlinejudge#question_8
    public int atoi(String str) {
        boolean foundSign = false;
        int sign = 1;
        
        boolean foundDigit = false;
        long num = 0; // we use long to preserve overflows
        
        for(int i = 0 ; i < str.length(); i++){
            char c = str.charAt(i);

            if (c == ' '){
                if (foundDigit) break;
                if (foundSign) return 0;
            } else if (c == '+' || c == '-'){
                if (foundSign) return 0;
                foundSign = true;
                sign = (c == '-') ? -1 : 1;
            } else if (c >= '0' && c <= '9'){
                foundDigit = true;
                int digit = c - '0';
                num *= 10;
                num += digit;
            } else {
                break;
            }
        }
        return retVal(num, sign);
    }
    
    int retVal(long num, int sign){
        long n = num;
        n *= sign;
        
        if (n >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (n <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)num*sign; // we're sure it is in range
    }
}