public class Solution {
    // Valid parantheses
    // http://leetcode.com/onlinejudge#question_20
    public boolean isValid(String s) {
        if (s == null) return true;
        
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : s.toCharArray()){
            if (c=='(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char p = stack.pop();
                if (c == ']' && p != '[') return false;
                else if (c == ')' && p != '(') return false;
                else if (c == '}' && p != '{') return false;
            }
        }
        
        return stack.isEmpty();
    }
}