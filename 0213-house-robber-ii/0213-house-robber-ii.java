class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = helper(0, nums, dp1, n - 1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = helper(1, nums, dp2, n);
        return Math.max(case1, case2);
    }
    public int helper(int i, int[] nums, int[] dp, int stop) {
        if (i >= stop) return 0;
        if (dp[i] != -1) return dp[i];

        int include = nums[i] + helper(i + 2, nums, dp, stop);
        int exclude = helper(i + 1, nums, dp, stop);

        return dp[i] = Math.max(include, exclude);
    }
}
