class Solution {
    public int maxProfit(int[] prices) {
        int minn= (int)1e9;
        int profit=0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<minn){
                minn= prices[i];
            }
            else{
                profit= Math.max(profit, prices[i]-minn);
            }
        }
        return profit;
        
    }
}