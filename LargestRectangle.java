public class Solution {

    // Largest Rectangle in Histogram
    // http://leetcode.com/onlinejudge#question_84
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        
        int prevVal = -1;
        boolean wasLastMax = false;
        for(int i = 0; i < height.length; i++){
            int val = height[i];
            
            if (wasLastMax && val == prevVal){
                prevVal = val;
                continue;
            }
            
            int gtOrEqOnLeft = 0,  gtOrEqOnRight = 0;
            for(int k = i-1; k >= 0; k--)
                if (height[k] >= val)
                    gtOrEqOnLeft++;
                else break;
            for(int k = i+1; k < height.length; k++)
                if (height[k] >= val)
                    gtOrEqOnRight++;
                else break;
            
            int area = (gtOrEqOnLeft + gtOrEqOnRight + 1 /* self */) * val;
            
            if (area > maxArea){
                maxArea = area;
                wasLastMax = true;
            } else {
                wasLastMax = false;
            }
            prevVal = val;
        }
        return maxArea;
    }
}