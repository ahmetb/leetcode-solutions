public class Solution {
    int[] steps = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] vals = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    // Integer to Roman
    // http://leetcode.com/onlinejudge#question_12
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        
        int i = 0;
        while(num > 0){
            int count = num/steps[i];
            num -= count * steps[i];
            while(count > 0){
                sb.append(vals[i]);
                count--;
            }
            i++;
        }
        return sb.toString();
    }
}