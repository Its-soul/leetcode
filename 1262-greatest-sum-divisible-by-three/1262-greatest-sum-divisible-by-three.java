import java.util.Arrays;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];

        for (int num : nums) {
            int[] temp = Arrays.copyOf(dp, 3);
            for (int i = 0; i < 3; i++) {
                if (temp[i] > 0 || i == 0) {
                    int newSum = temp[i] + num;
                    int rem = newSum % 3;
                    dp[rem] = Math.max(dp[rem], newSum);
                }
            }
        }

        return dp[0];
    }
}