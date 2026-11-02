class Solution {
    public int minMoves2(int[] nums){
        int n = nums.length;
         n  = n / 2;
        Arrays.sort(nums);
        int median = nums[n];
        int ans = 0;
        for (int i : nums)
            ans += Math.abs(i - median);
        return ans;
    }
}