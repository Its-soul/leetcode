class Solution {
    static int m;
    static int n;
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Integer[][] dp = new Integer[m][n];
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;
        return helper(grid, dp, 0, 0);
    }

    private int helper(int[][] grid, Integer[][] dp, int i, int j) {
        if (i >= m || j >= n || grid[i][j] == 1) return 0;
        if (i == m-1 && j == n-1) return 1;
        if (dp[i][j] != null) return dp[i][j];
        int down = helper(grid, dp, i+1, j);
        int right = helper(grid, dp, i, j+1);
        return dp[i][j] = down + right;
    }
}