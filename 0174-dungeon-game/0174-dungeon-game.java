class Solution {
    public int calculateMinimumHP(int[][] d) {
        int m = d.length;
        int n= d[0].length;
        int [][] dp = new int [m][n];
        return helper(0,0,d,dp);
    }
    public int helper(int i, int j, int [][]d, int [][]dp){
        int m = d.length;
        int n= d[0].length;
        if (i>=m || j>=n) return (int)1e9;
        if (i==m-1 && j==n-1){
            if (d[i][j]>0) return 1;
            else return Math.abs(d[i][j])+1;
        }
        if (dp[i][j]!=0) return dp[i][j];
        int down = helper(i+1,j, d, dp);
        int right = helper(i,j+1, d, dp);
        int need = Math.min(down, right)-d[i][j];

        return dp[i][j]= (need<=0)? 1: need;
    }
}