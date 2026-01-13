class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length+1;
        int [] dp = new int[n];
        
        for (int i= n-2; i>=0; i--){
            int len = 0;
            int max = -(int)1e9;
            int currMax = 0;
            for (int j = i; j <Math.min(n-1,i+k); j++) {
                len++;
                currMax = Math.max(currMax, arr[j]);
                int cost = currMax * len + dp[j+1];
                max = Math.max(max, cost);
            }
            dp[i]=max;   
        }
        return dp[0];
    }
}
//         return helper(arr, k, 0, n, dp);
//     }
//     public int helper(int[] arr, int k, int i, int n, Integer[] dp) {
//         if (i == n) return 0;
//         if(dp[i]!=null) return dp[i];
//         int len = 0;
//         int max = -(int)1e9;
//         int currMax = 0;
//         for (int j = i; j <Math.min(n,i+k); j++) {
//             len++;
//             currMax = Math.max(currMax, arr[j]);
//             int cost = currMax * len + helper(arr, k, j + 1, n, dp);
//             max = Math.max(max, cost);
//         }
//         return dp[i]= max;
//     }
// }