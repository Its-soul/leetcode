class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0,0);
    }
    public int helper(int [] nums, int target,int i,int sum){
        if (i==nums.length){
            return sum==target ? 1:0;
        }
        int take= helper(nums, target, i+1,sum+nums[i]);
        int diff=  helper(nums, target, i+1,sum-nums[i]);
        return take+diff;
    }
}