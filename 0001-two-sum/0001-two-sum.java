class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] array= Arrays.copyOf(nums, nums.length);
        Arrays.sort(array);
        int left=0;
        int right=nums.length-1;
        int lidx=0;
        int ridx=0;
        while(left<right){
            int sum= array[left]+array[right];
            if(sum==target){
                lidx=left;
                ridx=right;
                break;
            }
            if(sum>target){
                right--;
            }
            if(sum<target){
                left++;
            }
        }

        boolean firstFound = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == array[lidx] && !firstFound) {
                left = i;
                firstFound = true;
            } else if (nums[i] == array[ridx]) {
                right = i;
            }
        }
        return new int[]{left,right};
    }
}