class Solution {
    public int[] twoSum(int[] num, int target) {
        int left=0;
        int right=num.length-1;
        while(left<right){
            if (num[left]+num[right]>target){
                right--;
            }
            else if(num[left]+num[right]<target){
                left++;
            }
            else if(num[left]+num[right]==target){
                return new int[]{left+1, right+1};
            }
        }
        return new int[]{0,0};
    }
}