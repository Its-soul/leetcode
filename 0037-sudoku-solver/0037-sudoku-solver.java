class Solution {

    static int check = 0;

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
        check = 0;
    }

    public void solve(char[][] board, int row, int col) {

        if (row == 9) {
            check = 1;
            return;
        }

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;

        if (board[row][col] == '.') {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isSafe(board, row, col, ch)) {
                    board[row][col] = ch;

                    solve(board, nextRow, nextCol);

                    if (check == 1) return;

                    board[row][col] = '.';
                }
            }
        } else {
            solve(board, nextRow, nextCol);
        }
    }

    public boolean isSafe(char[][] board, int row, int col, char num) {

        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        int rRow = (row / 3) * 3;
        int cCol = (col / 3) * 3;

        for (int i = rRow; i < rRow + 3; i++) {
            for (int j = cCol; j < cCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}
