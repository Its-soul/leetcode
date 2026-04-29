class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int total=0;
        int maxx=0;
        int ans=0;
        for(int i=0; i<weights.length; i++){
            total+=weights[i];
            maxx= Math.max(maxx, weights[i]);
        }
        int left= maxx;
        int end= total;
        while(left<=end){
            int mid= left+ (end-left)/2;
            if(possible(mid, days, weights)){
                ans= mid;
                end= mid-1;
            }
            else{
                left= mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int mid, int days, int [] weights){
        int start=1;
        int sum=0;
        for(int curr:weights){
            if(sum+curr<=mid){
                sum+=curr;
            }
            else{
                start++;
                sum=curr;
            }
        }
        return (start>days)?false: true;
    }
}