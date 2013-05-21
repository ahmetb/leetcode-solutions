public class Solution {

    // Multiply Strings
    // http://leetcode.com/onlinejudge#question_43
    public String multiply(String num1, String num2) {
        int[] digits = new int[num1.length() + num2.length()];
        
        for(int i = num1.length()-1; i >= 0; i--){
            for(int j = num2.length()-1; j >= 0; j--){
                digits[i + j + 1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        
        int c = 0;
        for(int k = digits.length-1; k >= 0; k--){
            digits[k] += c;
            c = digits[k] / 10;
            digits[k] = digits[k] % 10;
        }
        
        int n = 0;
        while(n < digits.length && digits[n] == 0){
            n++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < digits.length; i++){
            sb.append(digits[i]);
        }
        
        return sb.length() > 0 ? sb.toString() : "0";
    }
}