class Solution {
    public int trap(int[] nums) {
        int n= nums.length;
        int [] leftmax= new int [n];
        int [] rightmax= new int [n];
        int rmax=0;
        int lmax=0;
        for(int i=0; i<n; i++){
            lmax= Math.max(lmax, nums[i]);
            leftmax[i]=lmax;
            rmax= Math.max(rmax, nums[n-i-1]);
            rightmax[n-i-1]= rmax;
        }
        int water=0;
        for(int i=0; i<n; i++){
            water+=Math.abs(Math.min(leftmax[i], rightmax[i])-nums[i]);
        }
        return water;
    }
}