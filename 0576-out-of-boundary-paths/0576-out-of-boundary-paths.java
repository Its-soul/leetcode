class Solution {
    static int [] dr= {-1,1,0,0};
    static int [] dc= {0,0,-1,1};
    static int mod= 1000000007;
    static Integer [][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp= new Integer [m][n][maxMove+1];
        return helper(startRow, startColumn, maxMove, m, n);
    }

    public static int helper(int i, int j, int maxMove, int row, int col){
        if(i<0 || i>=row || j<0 || j>=col){
            return 1;
        }
        if(maxMove<=0){
            return 0;
        }
        if(dp[i][j][maxMove]!=null) return dp[i][j][maxMove];

        
        int ans=0;
        for(int k=0; k<4; k++){
            ans= (ans+ helper(i+dr[k], j+dc[k], maxMove-1, row , col))%mod;
        }
        return dp[i][j][maxMove]=ans%mod;

    }
}