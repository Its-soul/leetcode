class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer [] dp = new Integer[n];
        return helper(arr, k, 0, n, dp);
    }
    public int helper(int[] arr, int k, int i, int n, Integer[] dp) {
        if (i == n) return 0;
        if(dp[i]!=null) return dp[i];
        int len = 0;
        int max = -(int)1e9;
        int currMax = 0;
        for (int j = i; j <Math.min(n,i+k); j++) {
            len++;
            currMax = Math.max(currMax, arr[j]);
            int cost = currMax * len + helper(arr, k, j + 1, n, dp);
            max = Math.max(max, cost);
        }
        return dp[i]= max;
    }
}