class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int k = n / 3;
        int [][] dp1 = new int[n][k + 1];
        for (int i=0; i<dp1.length; i++){
           Arrays.fill(dp1[i], -1); 
        } 
        int case1 = helper(0, n - 1, k, slices, dp1);
        int [][] dp2 = new int[n][k + 1];
        for (int i=0; i<dp2.length; i++){
           Arrays.fill(dp2[i], -1); 
        } 
        int case2 = helper(1, n, k, slices,dp2);
        return Math.max(case1, case2);
    }
    public static int helper(int i, int end, int k, int[] slices, int [][] dp) {
        if (k == 0) return 0;
        if (i >= end) return -(int)1e9 / 2;
        if (dp[i][k] != -1) return dp[i][k];
        int take = slices[i] + helper(i + 2, end, k - 1, slices, dp);
        int notake = helper(i + 1, end, k, slices, dp);

        return dp[i][k] = Math.max(take, notake);
    }
}
