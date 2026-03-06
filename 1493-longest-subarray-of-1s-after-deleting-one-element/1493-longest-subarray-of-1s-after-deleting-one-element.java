class Solution {
    public int longestSubarray(int[] nums) {
        int length=0;
        int left = 0, right=0;
        int maxx = 0, count = 0;
        while(right< nums.length){
            if(nums[right] == 0){
                count++;
            }
            while(count>1){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            if(count<=1){
                length = Math.max(length,right-left+1);
            }
            maxx = Math.max(maxx,length);
            right++;
        }
        return maxx-1;
    }
}