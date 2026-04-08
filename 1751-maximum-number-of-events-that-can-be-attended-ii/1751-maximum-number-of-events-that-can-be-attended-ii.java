 class Solution {
    int[][] dp;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        dp = new int[events.length][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(0, k, events);
    }

    private int solve(int i, int k, int[][] events) {
        if (i == events.length || k == 0) return 0;
        if (dp[i][k] != -1) return dp[i][k];
        int notTake = solve(i + 1, k, events);
        int next = findNext(events, i);
        int take = events[i][2] + solve(next, k - 1, events);
        return dp[i][k] = Math.max(take, notTake);
    }

    private int findNext(int[][] events, int i) {
        int end = events[i][1];
        int left = i + 1, right = events.length - 1;
        int ans = events.length;

        while (left <= right) {
            int mid = left+(right-left)/2;
            if (events[mid][0] > end) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }

        return ans;
    }
}