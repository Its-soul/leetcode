class Solution {
    public int maxHeight(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            Arrays.sort(arr[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            return b[0]*b[1]*b[2]- a[0]*a[1]*a[2];
        });

        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            dp[i] = arr[i][2];
        }
        int maxx = dp[0];
        for (int curr = 1; curr < n; curr++) {
            for (int prev = 0; prev < curr; prev++) {
                if (arr[curr][0] <= arr[prev][0] && arr[curr][1] <= arr[prev][1] && arr[curr][2] <= arr[prev][2]) {
                    if (dp[curr]<dp[prev]+arr[curr][2]){
                        dp[curr]=dp[prev]+arr[curr][2];
                    }
                }
            }
            maxx = Math.max(maxx, dp[curr]);
        }

        return maxx;
    }
}