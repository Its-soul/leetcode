class Solution {
    public int maxRotateFunction(int[] nums) {
        int n= nums.length;
        int sum= 0;
        int total= 0;

        for(int i= 0; i<n; i++){
            sum+= nums[i];
            total+= i*nums[i];
        }

        int maxx = total;

        for(int i= n-1; i>0; i--){
            total= total+ sum- n*nums[i];
            maxx= Math.max(maxx,total);
        }

        return maxx;
    }
}