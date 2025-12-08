class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int [][] dp = new int [n][n];
        for (int i = 0; i<n; i++){
            Arrays.fill(dp[i],'#');
        }
        return helper(0,0,t, dp);   
    }
    public int helper(int i, int j, List<List<Integer>> t, int [][] dp){
        int n = t.size();
        if (i==n-1|| j==n-1) return t.get(i).get(j);
        if(dp[i][j]!='#') return dp[i][j];
        int down= t.get(i).get(j) + helper(i+1,j,t,dp);
        int right= t.get(i).get(j) + helper(i+1,j+1,t,dp);
        return dp[i][j]=Math.min(down,right);
    }
}