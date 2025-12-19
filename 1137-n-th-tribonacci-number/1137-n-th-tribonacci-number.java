class Solution {
    public int tribonacci(int n) {
        int dp[]=new int[n+1];
        for(int i=0;i<n+1;i++){
            if(i<2) dp[i]=i;
            else if(i==2) dp[i]=1;
            else dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            
        }
        return dp[n];        
    }
}