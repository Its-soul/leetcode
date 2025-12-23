class Solution {
    public int maxHeight(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            Arrays.sort(arr[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        int n = arr.length;
        int[] dp = new int[n];
        int maxx = 0;
        for (int curr = 0; curr < n; curr++) {
            dp[curr] = arr[curr][2]; 
            for (int prev = 0; prev < curr; prev++) {
                if (arr[curr][0] >= arr[prev][0] && arr[curr][1] >= arr[prev][1] && arr[curr][2] >= arr[prev][2]) {
                    dp[curr] = Math.max(dp[curr], dp[prev] + arr[curr][2]);
                }
            }
            maxx = Math.max(maxx, dp[curr]);
        }

        return maxx;
    }
}