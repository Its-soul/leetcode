class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int max=0;
        for(int elm:piles){
            if(max<elm) max=elm;
        }
        int end=max;
        int mid=0;
        int ans=end;
        while(start<=end){
            mid=start+(end-start)/2;
            if(possible(mid,h,piles)){
                ans=mid;
                end=mid-1;
            }
            else{
            
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int mid,int h,int[] piles){
        long sum=0;
        for(int curr: piles){
            sum+=(curr+mid-1)/mid; 
        }
        if(sum>h)return false;
        return true;

    }
}