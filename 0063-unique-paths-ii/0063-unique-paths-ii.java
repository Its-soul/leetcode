class Solution {
    int n;
    int m;
    public int uniquePathsWithObstacles(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Integer dp[][] = new Integer [n+1][m+1];

        return helper(0,0, grid, dp);
        
    }

    public int helper(int i, int j, int grid[][], Integer dp[][]){
        if(i>=n || j>=m || grid[i][j]==1){
            return 0;
        }
        if(i == n-1 && j == m-1){
            return 1;
        }
        if(dp[i][j] != null) return dp[i][j];

        return dp[i][j] = helper(i+1, j, grid, dp) + helper(i, j+1, grid, dp);
    }
}