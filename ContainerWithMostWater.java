public class Solution {
    // Container With Most Water
    // http://leetcode.com/onlinejudge#question_11
    public int maxArea(int[] height) {
        int maxArea = 0;
        
        int l = 0, r = height.length-1;
        while(r >= l){
            int area = (r-l)*Math.min(height[r], height[l]);
            if (area > maxArea) maxArea = area;
            
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
    
    // O(N^2) didn't pass the large input 10000..1
    public int bruteForce_maxArea(int[] height) {
        int maxArea = 0;
        
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                int area = (j-i)*Math.min(height[i], height[j]);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }
    
    
}