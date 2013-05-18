public class Solution {
    // Set Matrix Zeroes
    // http://leetcode.com/onlinejudge#question_73
    public void setZeroes(int[][] matrix) {
        // store zeroes in first row and first col, doesn't use extra space. 
        // time complexity O(mn)
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row0clear = false, col0clear = false;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    if (j == 0)
                        col0clear = true;
                    if (i == 0)
                        row0clear = true;
                    else{
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        // clear inner cells
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // clear first row
        if(row0clear){
            for(int ci = 0; ci < n;ci++){
                matrix[0][ci] = 0;
            }
        }

        // clear first col
        if(col0clear){
            for(int ri = 0; ri < m;ri++){
                matrix[ri][0] = 0;
            }
        }
    }
}