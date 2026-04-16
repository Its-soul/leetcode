class Solution {

    Integer [][] dp;
    public int lengthOfLIS(int[] nums) {
        dp =new Integer[nums.length][nums.length];
        return helper(0,-1,nums);
    }

    public int helper(int i, int prev, int[] nums){
        if(i==nums.length) return 0;
        int take=0;
        if(dp[i][prev+1]!=null) return dp[i][prev+1];
        if(prev==-1 || nums[i]>nums[prev]){
            take= 1+ helper(i+1, i, nums);
        }
        int notake= helper(i+1, prev, nums);
        return dp[i][prev+1]=Math.max(take, notake);
    }
}