class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[row][cols];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i],-1);
        }
        int maxx = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                maxx = Math.max(maxx, helper(matrix, i, j, dp));
            }
        }return maxx;
    }
    public int helper(int[][] matrix, int i, int j, int[][] dp) {
        int row = matrix.length;
        int cols = matrix[0].length;
        if (i< 0 || j< 0 || i>= row || j>=cols) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            up = helper(matrix, i - 1, j, dp);
        }
        if (i<row - 1 && matrix[i + 1][j] > matrix[i][j]) {
            down = helper(matrix, i + 1, j, dp);
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            left = helper(matrix, i, j - 1, dp);
        }
        if (j<cols - 1 && matrix[i][j + 1] > matrix[i][j]) {
            right =helper(matrix, i, j + 1, dp);
        }
        int max = Math.max(Math.max(up, down), Math.max(left, right));
        dp[i][j] = 1+max;
        return dp[i][j];
    }
}
