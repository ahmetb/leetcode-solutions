public class Solution {
    // Valid Sudoku
    // http://leetcode.com/onlinejudge#question_36
    public boolean isValidSudoku(char[][] board) {
        // check cols
        if (!checkVector(board, true))
            return false;
        
        // check rows
        if(!checkVector(board, false))
            return false;
        
        // check 3x3s
        for(int xOff = 0; xOff < 9; xOff += 3){
            for(int yOff = 0; yOff < 9; yOff += 3){
                if (!check3x3(board, xOff, yOff))
                    return false;
            }
        }
        return true;
    }
    
    boolean checkVector(char[][] board, boolean checkCol){
        for(int r = 0; r < board.length; r++){
            int vector = 0;
            for(int c = 0; c < board[0].length; c++){
                char v = (checkCol) ? board[c][r] : board[r][c];
                int val = v == '.' ? 0 : v-'0';
                int mask = 1<<val;
                if ((vector & mask) > 0)
                    return false;
                if (val > 0) vector |= mask;   
            }
        }
        return true;
    }
    
    boolean check3x3(char[][] board, int xOffset, int yOffset){
        int vector = 0;
        for(int i = xOffset; i < xOffset+3; i++){
            for(int j = yOffset; j < yOffset+3; j++){
                int val = board[i][j] == '.' ? 0 : (board[i][j]-'0');
                if (val > 0) {
                    int mask = 1<<val;
                    if ((vector & mask) > 0)
                        return false;
                    vector |= mask;       
                }
            }
        }
        return true;
    }
}