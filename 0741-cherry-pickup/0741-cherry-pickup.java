class Solution {
    static int n;
    static Integer [][][] dp;
    public int cherryPickup(int[][] grid) {
        n= grid.length;
        dp= new Integer [n][n][n];
        int ans= helper(0,0,0,0,grid);
        return ans<0?0:ans;
    }

    public static int helper(int row1, int row2, int col1, int col2, int [][] grid){
        if(row1>=n || col1>=n || row2>=n || col2>=n || grid[row1][col1]==-1 || grid[row2][col2]==-1) return -(int)1e9;
        if(row1==n-1 && col1==n-1) return grid[row1][col1];
        col2= row1+col1-row2;
        int cherry = (row1==row2 && col1==col2)?grid[row1][col1]:grid[row1][col1]+grid[row2][col2];

        if(dp[row1][row2][col1]!=null) return dp[row1][row2][col1];
        int take1= helper(row1+1, row2+1,col1, col2, grid);
        int take2= helper(row1, row2,col1+1, col2+1, grid);
        int take3= helper(row1+1, row2,col1, col2+1, grid);
        int take4= helper(row1, row2+1,col1+1, col2, grid);
        return dp[row1][row2][col1]=cherry+Math.max(take1,Math.max(take2, Math.max(take3, take4)));

    }

}