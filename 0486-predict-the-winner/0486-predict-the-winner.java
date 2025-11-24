class Solution {
    public boolean predictTheWinner(int[] nums) {
        int res= helper(nums, 0, nums.length-1);
        if (res>=0) return true;
        return false;
        
    }
    public int helper(int[] nums, int i, int j){
        if (i==j) return nums[i];
        int leftpick= nums[i]- helper(nums, i+1, j);
        int rightpick= nums[j]- helper(nums, i, j-1);
        return Math.max(leftpick,rightpick);
    }
}