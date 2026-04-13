class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minn= (int)1e9;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                minn= Math.min(minn, Math.abs(i-start));
            }
        }
        return minn;
    }
}