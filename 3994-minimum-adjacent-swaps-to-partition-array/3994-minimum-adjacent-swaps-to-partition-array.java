class Solution {
    int mod = 1_000_000_007;
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long ans=0;
        int mid=0;
        int right=0;

        for(int n:nums){
            if(n<a){
                ans+=mid+right;
            }else if(n<=b){
                ans+=right;
                mid++;
            }else{
                right++;
            }
        }
        return (int)(ans%mod);
    }
}