public class Solution {
    
    // Sqrt(x) 
    // http://leetcode.com/onlinejudge#question_69
    public static int sqrt(int x) {
        // count digits in binary repr of x.
        int d = 0, j = x, i = 0;
        while(j != 0){
            i++;
            if ((j&1)==1)
                d = i;
            j >>= 1;
        }
        
        int candidDigits = d/2;
        long min = Math.max(0, 1<<(candidDigits-1));
        long max = 1<<(candidDigits+1);
        
        long lo = min, hi = max;
        while(hi >= lo){
            long med = (hi+lo)/2;
            long medsq = med*med;

            if (medsq == x) return (int)med;
            else if (medsq < x) lo = med+1;
            else if (medsq > x) hi = med-1;
        }
        
        // if result not found, use one termination point 
        
        return (int) ((hi*hi > x)? hi - 1 : hi);
    }
}