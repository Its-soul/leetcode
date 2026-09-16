// class Solution {

//     Integer dp[][];

//     public int longestSubsequence(int[] arr, int difference){
//         dp = new Integer [arr.length][arr.length+1];
//         return helper(arr, difference, 0, -1);
//     }

//     public int helper(int arr[], int diff, int i, int prev){

//         if(i >= arr.length) return 0;
//         if(dp[i][prev+1]!=null) return dp[i][prev+1];

//         int take = 0;
//         if(prev == -1 || arr[i] - arr[prev] == diff){
//             take = 1 + helper(arr, diff, i+1, i);
//         }
//         int notake = helper(arr, diff, i+1, prev);

//         return dp[i][prev+1] = Math.max(take, notake);
//     }

// }

class Solution {
    public int longestSubsequence(int[] arr, int difference) {

        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for (int num : arr) {

            int prev = num - difference;

            dp.put(num, dp.getOrDefault(prev, 0) + 1);

            ans = Math.max(ans, dp.get(num));
        }

        return ans;
    }
}