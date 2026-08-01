// class Solution {
//     public boolean predictTheWinner(int[] nums) {
//         int res= helper(nums, 0, nums.length-1);
//         if (res>=0) return true;
//         return false;
        
//     }
//     public int helper(int[] nums, int i, int j){
//         if (i==j) return nums[i];
//         int leftpick= nums[i]- helper(nums, i+1, j);
//         int rightpick= nums[j]- helper(nums, i, j-1);
//         return Math.max(leftpick,rightpick);
//     }
// }

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = nums.clone(); 
        
        for (int diff = 1; diff < n; ++diff) {
            for (int j = n - 1; j - diff >= 0; --j) {
                int i = j - diff;
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        
        return dp[n - 1] >= 0;
    }
}