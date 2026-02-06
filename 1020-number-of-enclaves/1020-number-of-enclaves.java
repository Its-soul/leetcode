class Solution {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public int numEnclaves(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] vis = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || j == 0 || i == rows - 1 || j == cols - 1) && board[i][j] == 1 && !vis[i][j]) {
                    dfs(i, j, board, vis);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }return count;
    }

    public void dfs(int i, int j, int[][] board, boolean[][] vis) {
        int rows = board.length;
        int cols = board[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols) return;
        if (board[i][j] == 0 || vis[i][j]) return;
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            dfs(i + dr[k], j + dc[k], board, vis);
        }
    }
}
