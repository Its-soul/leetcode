class Solution {
    public int rob(int[] nums) {
        int [] dp = new int [nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums, dp);        
    }
    public static int helper(int i, int[] nums,int[] dp){
        if(i>=nums.length) return 0;
        if (dp[i]!=-1) return dp[i];
        int include = nums[i]+ helper(i+2,nums, dp);
        int exclude = helper(i+1, nums, dp);

        return dp[i]=Math.max(include, exclude);
    }
}