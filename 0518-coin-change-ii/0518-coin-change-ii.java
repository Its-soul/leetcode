class Solution {
    public int change( int amount,int[] coins) {
        Integer[][] dp=new Integer[coins.length][amount+1];
        return helper(coins,amount,coins.length-1,dp); 
    }
    public int helper(int[] coins,int target,int i,Integer[][] dp){
        if(target==0){
            return 1;
        }
        if(i==0){
            if(target%coins[0]==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(target<0){
            return 0;
        }
        if(dp[i][target]!=null){
            return dp[i][target];
        }
        int take=0;
        if(coins[i]<=target){
            take=helper(coins,target-coins[i],i,dp);
           
        }
        int nottake= helper(coins,target,i-1,dp);
        
        dp[i][target]=take+nottake;
        return dp[i][target];
    }
}