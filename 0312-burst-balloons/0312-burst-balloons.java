class Solution {
    public int maxCoins(int[] nums) {
        int n= nums.length;
        int[] arr = new int [n+2];
        arr[0]=1;
        for(int i= 1; i<=n; i++){
            arr[i]= nums[i-1];
        }
        arr[n+1]= 1;
        int [][] dp = new int [n+2][n+2];
        return helper(arr, 1, n, dp);
    }
    public int helper(int [] arr, int i, int j, int [][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int max= -(int)1e9;
        for(int idx=i; idx<=j; idx++){
            int cost = arr[i-1]*arr[idx]*arr[j+1] + helper(arr, idx+1, j,dp)+helper(arr, i, idx-1, dp);
            max= Math.max(max, cost);
        }
        return dp[i][j]= max;
    }
}