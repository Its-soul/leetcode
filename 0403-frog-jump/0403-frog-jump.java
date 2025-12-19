class Solution {

    public boolean canCross(int[] stones) {
        int n = stones.length;
        Boolean[][] dp = new Boolean[n][n + 1];
        return helper(stones, 0, 0, dp);
    }

    public boolean helper(int[] stones, int index, int lastJump, Boolean[][] dp) {
        if (index == stones.length - 1) return true;

        if (dp[index][lastJump] != null)
            return dp[index][lastJump];

        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if (jump <= 0) continue;

            int nextPos = stones[index] + jump;

            for (int i = index + 1; i < stones.length; i++) {
                if (stones[i] == nextPos) {
                    if (helper(stones, i, jump, dp)) {
                        dp[index][lastJump] = true;
                        return true;
                    }
                }
                if (stones[i] > nextPos) break;
            }
        }

        dp[index][lastJump] = false;
        return false;
    }
}