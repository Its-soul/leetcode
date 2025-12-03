class Solution {
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int dp[][] = new int[row][col];
        return helper(0,0,row,col,grid,dp);
    }
    public int helper(int i,int j,int m,int n,int[][] grid,int[][] dp){
        if (i >= m || j >= n) return (int)1e9;
        if(i==m-1 && j==n-1) return grid[i][j];
        if(dp[i][j]!=0) return dp[i][j];
        int rightsum=grid[i][j]+helper(i,j+1,m,n,grid,dp);
        int downsum=grid[i][j]+helper(i+1,j,m,n,grid,dp);
        return dp[i][j]=Math.min(rightsum,downsum);
    }
}