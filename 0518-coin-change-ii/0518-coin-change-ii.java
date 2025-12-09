class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        return helper(n - 1, coins, amount, dp);
    }

    public int helper(int i, int[] coins, int amount, Integer[][] dp) {
        if (amount == 0) return 1;
        if (i < 0) return 0;
        if (dp[i][amount] != null) return dp[i][amount];
        if (i==0){
            if(amount%coins[0]==0) return 1;
            else return 0;
        }
        int notTake = helper(i - 1, coins, amount, dp);
        int take = 0;
        if (coins[i] <= amount) take = helper(i, coins, amount - coins[i], dp);

        return dp[i][amount] = notTake+take;
    }
}
