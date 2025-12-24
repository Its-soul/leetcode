class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int[][] dp = new int[n][1001]; 
        int ans = 2;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j]+500;
                // if(diff<0) {
                //     diff+= 500;
                // }
                if (dp[j][diff] > 0) {
                    dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                } else {
                    dp[i][diff] = 2; 
                }
                if (dp[i][diff] > ans) ans = dp[i][diff];
            }
        }

        return ans;
    }
}