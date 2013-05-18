class Solution {
public:
    // Pow(x,n)
    // http://leetcode.com/onlinejudge#question_50
    double pow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        if (n % 2 != 0)
            return x * pow(x, n-1);
        return pow(x * x, n/2);
    }
};