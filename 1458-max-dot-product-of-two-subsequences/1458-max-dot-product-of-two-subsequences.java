class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        Integer [][] dp= new Integer [nums1.length+1][nums2.length+1];
        return helper(nums1, nums2, 0,0, dp);
    }
    public static int helper(int[] nums1, int[] nums2, int i, int j,Integer [][] dp){
        if (i==nums1.length || j ==nums2.length) return -(int)1e9;
        if (dp[i][j]!=null) return dp[i][j];
        int take = Math.max(nums1[i] * nums2[j],nums1[i] * nums2[j] + helper(nums1, nums2, i+1, j+1, dp));
        int notake = Math.max(helper(nums1, nums2, i, j+1, dp),helper(nums1, nums2, i+1, j, dp));
        return dp[i][j]= Math.max(take, notake);
    }
}