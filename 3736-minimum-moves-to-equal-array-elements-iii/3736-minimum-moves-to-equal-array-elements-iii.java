class Solution {
    public int minMoves(int[] nums) {
        int maxx = 0;
        int sum = 0;
        for(int i : nums){
            sum += i;
            if(i>maxx){
                maxx = i;
            }
        }
        return (nums.length * maxx) - sum;
    }
}