class Solution {

    public boolean isSafe(char[][] board, int row, int col, char num) {


        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') continue;

                char ch = board[i][j];
                board[i][j] = '.';  

                if (!isSafe(board, i, j, ch)) {
                    return false;
                }

                board[i][j] = ch;        
            }
        }
        return true;
    }
}
