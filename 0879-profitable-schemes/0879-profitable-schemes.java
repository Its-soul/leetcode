class Solution {
    static Integer [][][] dp;
    static int mod= 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int totalprofit=0;
        for(int i=0; i<profit.length; i++){
            totalprofit+=profit[i];
        }
        dp= new Integer [group.length][n+1][minProfit+1];
        int ans =helper(0,n, minProfit, 0, group, profit)%mod;
        return ans;
    }

    public static int helper(int i, int n, int minProfit, int curr_profit, int [] group, int [] profit){
        
        if(i==group.length){
           if(curr_profit>=minProfit) return 1;
           return 0;
        }
        if(dp[i][n][curr_profit]!=null) return dp[i][n][curr_profit];
        int take=0;
        if(group[i]<=n){
            take= helper(i+1, n-group[i], minProfit, Math.min(minProfit, curr_profit + profit[i]) ,group, profit);
        }
        int notake= helper(i+1, n, minProfit, curr_profit, group, profit);
        return dp[i][n][curr_profit]=(take+notake)%mod;
    }

}
