class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], '#');  
        }
        return helper(0, coins, amount, dp);
    }

    private int helper(int i, int[] coins, int amount, int[][] dp) {
        if (amount == 0) return 0;
        if (amount < 0 || i == coins.length) return -1;

        if (dp[i][amount] != '#') return dp[i][amount];

        int pick = helper(i, coins, amount - coins[i], dp);
        if (pick != -1) pick++;

        int notPick = helper(i + 1, coins, amount, dp);

        int ans;
        if (pick == -1 && notPick == -1) ans = -1;
        else if (pick == -1) ans = notPick;
        else if (notPick == -1) ans = pick;
        else ans = Math.min(pick, notPick);

        return dp[i][amount] = ans;
    }
}
