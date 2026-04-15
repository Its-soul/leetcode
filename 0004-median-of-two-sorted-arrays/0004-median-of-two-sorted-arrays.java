class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] nums= new int [nums1.length+ nums2.length];
        for(int i=0; i<nums1.length; i++){
            nums[i]=nums1[i];
        }
        for(int j=0; j<nums2.length; j++){
            nums[j+nums1.length]= nums2[j];
        }
        Arrays.sort(nums);
        int n= nums.length;
        if(n%2!=0){
            return nums[n/2];
        }
        return (double)(nums[n/2]+nums[n/2-1])/2;
    }
}