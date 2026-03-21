class Solution {
    Integer[][] dp;

    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        dp = new Integer[n][2];
        return Math.min(
            helper(nums1, nums2, 0, 0),
            helper(nums1, nums2, 0, 1)
        );
    }

    private int helper(int[] nums1, int[] nums2, int i, int swapped) {
        if (i == nums1.length) return 0;

        if (dp[i][swapped] != null) return dp[i][swapped];

        int prev1, prev2;

        if (i == 0) {
            prev1 = -1;
            prev2 = -1;
        } else {
            prev1 = nums1[i - 1];
            prev2 = nums2[i - 1];

            if (swapped == 1) {
                int temp = prev1;
                prev1 = prev2;
                prev2 = temp;
            }
        }

        int ans = Integer.MAX_VALUE / 2;

        if (nums1[i] > prev1 && nums2[i] > prev2) {
            ans = helper(nums1, nums2, i + 1, 0);
        }
        if (nums1[i] > prev2 && nums2[i] > prev1) {
            ans = Math.min(ans, 1 + helper(nums1, nums2, i + 1, 1));
        }

        return dp[i][swapped] = ans;
    }
}