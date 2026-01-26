class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][]dp = new int [n+1][amount+1];
        int inf= amount+1;
        for(int i=0; i<=n;i++){
            Arrays.fill(dp[i],inf);
            dp[i][0]=0;
        }
        for(int i =1; i<=n;i++){
            for(int j=1; j<=amount;j++){
                dp[i][j]= dp[i-1][j];
                if(coins[i-1] <= j){
                    dp[i][j]= Math.min(dp[i][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        return dp[n][amount]>= amount+1 ? -1 : dp[n][amount];
    }
    // public int helper(int[] coins, int amount, int i){
    //     if (amount<0 ||i==coins.length) return -1;
    //     if (amount==0 ) return 0;
    //     int take = helper(coins, amount-coins[i], i);
    //     if (take!=-1) take++;
    //     int notake = helper(coins, amount, i+1);
    //     if (take == -1) return notake;
    //     if (notake == -1) return take;
    //     return Math.min(take, notake);
    // }
}