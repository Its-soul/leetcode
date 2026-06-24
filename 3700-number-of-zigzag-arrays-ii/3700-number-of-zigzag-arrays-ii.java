// class Solution {
//     static final int MOD = 1_000_000_007;
//     public int zigZagArrays(int n, int l, int r) {
//         int m = r - l + 1;
//         long[] dp = new long[m];
//         for (int i = 0; i < m; i++) {
//             dp[i] = 1;
//         }
//         for (int i = 2; i <= n; i++) {
//             long[] pref = new long[m];
//             pref[0] = dp[0];
//             for (int j = 1; j < m; j++) {
//                 pref[j] = (pref[j - 1] + dp[j]) % MOD;
//             }
//             long[] newDp = new long[m];
//             if (i % 2 == 0) {
//                 for (int j = 1; j < m; j++) {
//                     newDp[j] = pref[j - 1];
//                 }
//             } else {
//                 long total = pref[m - 1];
//                 for (int j = 0; j < m - 1; j++) {
//                     newDp[j] = (total - pref[j] + MOD) % MOD;
//                 }
//             }
//             dp = newDp;
//         }
//         long ans = 0;
//         for (long x : dp) {
//             ans = (ans + x) % MOD;
//         }
//         return (int)(ans * 2 % MOD);
//     }
// }

class Solution {
    long mod = 1000000007L;

    public long[][] multiply(long[][] A, long[][] B) {
        int sz = A.length;

        long[][] c = new long[sz][sz];

        for (int i=0; i<sz; i++) {
            for (int k = 0; k < sz; k++) {
                if (A[i][k] == 0) continue;

                long cur = A[i][k];

                for (int j=0; j<sz; j++) {
                    if (B[k][j] == 0) continue;

                    c[i][j] = (c[i][j]+cur*B[k][j]) % mod;
                }
            }
        }

        return c;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int sz = 2 * m;

        long[][] T = new long[sz][sz];

        for (int x=0; x<m; x++) {

            for (int y=x+1; y<m; y++) {
                T[x][m + y] = 1;
            }

            for (int y=0; y<x; y++) {
                T[m+x][y] = 1;
            }
        }

        long[][] result = new long[sz][sz];
        for (int i=0; i<sz; i++) {
            result[i][i] = 1;
        }

        long power = n-1;

        while (power>0) {
            if ((power & 1) == 1) {
                result = multiply(result, T);
            }

            T = multiply(T, T);
            power >>= 1;
        }

        long answer = 0;

        for (int i=0; i<sz; i++) {
            long rowSum = 0;

            for (int j=0; j<sz; j++) {
                rowSum = (rowSum + result[i][j]) % mod;
            }

            answer = (answer + rowSum) % mod;
        }

        return (int) answer;
    }
}