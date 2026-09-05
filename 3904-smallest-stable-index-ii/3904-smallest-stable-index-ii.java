class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;
        int[] suffix_min = new int[n];
        suffix_min[n - 1] = nums[n - 1];
        int maxx = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; i--) {
            suffix_min[i] = Math.min(nums[i], suffix_min[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            maxx = Math.max(maxx, nums[i]);
            int minn = suffix_min[i];

            if (maxx - minn <= k) {
                return i;
            }
        }

        return -1;
    }
}