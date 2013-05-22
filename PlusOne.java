public class Solution {
    // Plus one
    // http://leetcode.com/onlinejudge#question_66
    public int[] plusOne(int[] digits) {
        int c = 0;
        
        digits[digits.length-1]++;
        
        for(int i = digits.length-1; i >= 0; i--){
            int d = digits[i] + c;
            
            digits[i] = d % 10;
            c = d / 10;
        }
        
        if (c > 0){
            int[] ndigits = new int[digits.length+1];
            ndigits[0] = c;

            System.arraycopy(digits, 0, ndigits, 1, digits.length);
            digits = ndigits;
        }
        return digits;
    }
}