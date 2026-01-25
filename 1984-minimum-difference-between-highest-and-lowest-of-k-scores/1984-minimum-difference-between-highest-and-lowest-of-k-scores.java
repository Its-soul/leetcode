class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);  
        int n = nums.length;
        if (k == 1) return 0; 
        int minn = (int)1e9;
        for (int i = 0; i<n-k+1; i++) {
            int diff = nums[i+k-1] - nums[i];
            minn = Math.min(minn, diff);
        }
        return minn;
    }
}