public class Solution {
    // Palindrome Number
    // http://leetcode.com/onlinejudge#question_9
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        
        int digitCount = 0;
        int j = x;
        while (j > 0){
            digitCount++;
            j /= 10;
        }
        
        for(int i = 0; i < digitCount / 2; i++){
            // int ith from last
            int f = 0, s = 0;
            j = x;
            for(int k = 0; k <= i; k++){
                f = j % 10;
                j /= 10;
            }
            j = x;
            for(int k = 0; k < digitCount-i; k++){
                s = j % 10;
                j /= 10;
            }
            
            if (f != s) return false;
        }
        return true;
    }
}