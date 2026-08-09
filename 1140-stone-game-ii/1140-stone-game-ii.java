class Solution {
    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return helper(0, 1);
    }

    public int helper(int i, int M) {
        if (i >= n) return 0;

        if (dp[i][M] != 0)
            return dp[i][M];

        if (2 * M >= n - i)
            return dp[i][M] = suffix[i];

        int best = 0;

        for (int x = 1; x <= 2 * M; x++) {
            int opponent = helper(i + x, Math.max(M, x));
            best = Math.max(best, suffix[i] - opponent);
        }

        return dp[i][M] = best;
    }
}