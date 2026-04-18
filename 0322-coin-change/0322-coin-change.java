class Solution {
    Integer [][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length][amount+1];
        return helper(coins, amount , 0);
    }
    public int helper(int[] coins, int amount, int i){
        if(amount==0) return 0;
        if(i==coins.length || amount<0) return -1;
        if(dp[i][amount]!=null) return dp[i][amount];
        int take= -1;
        if(coins[i]<=amount){
            take= helper(coins, amount-coins[i], i);
            if(take!=-1){
                take++;
            }
        }
        int notake= helper(coins, amount, i+1);
        if(take==-1) return dp[i][amount]=notake;
        if(notake==-1) return dp[i][amount]=take;
        return dp[i][amount]=Math.min(take, notake);
    }
}