class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] bonus = new int[n];

        for (int i = 0; i < n; i++) {
            int fi = items[i][0];

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % fi == 0) {
                    bonus[i]++;
                }
            }
        }

        int[] dp = new int[budget + 1];
        
        for (int i = 0; i < n; i++) {
            int p = items[i][1];
            int b = bonus[i];

            int[] ndp = dp.clone();

            for (int r = 0; r < p && r <= budget; r++) {
                int best = dp[r];
                int m = 1;

                for (int t = r + p; t <= budget; t += p, m++) {
                    ndp[t] = Math.max(ndp[t], b + m + best);
                    best = Math.max(best, dp[t] - m);
                }
            }

            dp = ndp;
        }

        int res = 0;

        for (int v : dp) {
            res = Math.max(res, v);
        }

        return res;
    }
}