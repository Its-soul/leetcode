// class Solution {
//     public int lengthOfLIS(int[] nums) {

// memo:-

//         Integer[][] dp = new Integer[nums.length][nums.length + 1];
//         return helper(nums, 0, -1, dp);
//     }
//     public int helper(int[] nums, int curr, int prev, Integer[][] dp) {
//         if (curr == nums.length) {
//             return 0;
//         }
//         if (dp[curr][prev + 1] != null) {
//             return dp[curr][prev+1];
//         }
//         int take = 0;
//         if (prev == -1 || nums[curr] > nums[prev]) {
//             take = 1 + helper(nums, curr + 1, curr, dp);
//         }
//         int not = helper(nums, curr + 1, prev, dp);
//         return dp[curr][prev+1] = Math.max(take, not);
//     }

// }


// one d dp:-

//         int n=nums.length;
//         int[] dp=new int[n];
//         Arrays.fill(dp,1);
//         int ans=1;
//         for(int i=0;i<dp.length;i++){
//             for(int j=0;j<i;j++){
//                 if(nums[i]>nums[j]){
//                     dp[i]=Math.max(dp[i],1+dp[j]);
//                 }
//             }
//             ans=Math.max(ans,dp[i]);
//         }
//         return ans;
        
//     }
// }

// 2d dp:-

//         int n = nums.length;
//         int [][] dp = new int [n+1][n+1];
//         for(int curr=n-1; curr>=0; curr--){
//             for(int prev=curr-1;prev>=-1; prev--){
//                 int notake= dp[curr+1][prev+1];
//                 int take=0;
//                 if (prev==-1|| nums[curr]>nums[prev]){
//                     take= 1+dp[curr+1][curr+1];
//                 }
//                 dp[curr][prev+1]= Math.max(take, notake);
//             }
//         }return dp[0][0];
//     }
// }


// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int maxx = 1;

//         for (int i = 0; i < n; i++) {
//             int curr = 1;
//             int prev = nums[i];
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[j] > prev) {
//                     prev = nums[j];
//                     <
//                     n >++;
//                 }
//             }maxx = Math.max(maxx, curr);
//         }return maxx;
//     }
// }


// binary search one use when the constraints are high:
class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int index = lowerBound(temp, nums[i]);
                temp.set(index, nums[i]);
            }
        }return temp.size();
    }

    public int lowerBound(ArrayList<Integer> temp, int target) {
        int low = 0;
        int high = temp.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (temp.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}