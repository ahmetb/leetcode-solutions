public class Solution {
    // Longest Palindrome O(n^2), no extra space
    // http://leetcode.com/onlinejudge#question_5
    public String longestPalindrome(String s){
        int start = -1;
        int end = -1;
        int maxLen = -1;

        for(int i = 0; i < s.length(); i++){
            int[] p1 = longestPalindromeAround(s, i, i);

            if (p1 != null){
                int len = p1[1]-p1[0]+1;
                if (len>maxLen){
                    start = p1[0]; end = p1[1];
                    maxLen = len;
                }
            }

            int[] p2 = longestPalindromeAround(s, i, i+1);

            if (p2 != null){
                int len = p2[1]-p2[0]+1;
                if (len>maxLen){
                    start = p2[0]; end = p2[1];
                    maxLen = len;
                }
            }
        }
        return s.substring(start, end+1);
    }

    static int[] longestPalindromeAround(String s, int i, int j){
        int l = i, r = j;

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        // when terminated l is lower, r is larger
        return new int[]{l+1, r-1};
    }
}