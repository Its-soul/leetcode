class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n= stones.length;
        int total=0;
        for (int i: stones){
            total+=i;
        }
        int sum= total/2;
        boolean [][] dp = new boolean [n][sum+1];

        for(int i=0; i<=sum; i++) {
            if(stones[0]==i) {
                dp[0][i]=true;
            }
        }

        for (int i=0; i<dp.length;i++){
            dp[i][0]= true;
        }
        for(int i=1; i<dp.length;i++){
            for (int j=1; j<dp[0].length;j++){
                int curr=stones[i];
                if (j==curr) dp[i][j]=true;
                else if(j>curr){
                    dp[i][j]= dp[i-1][j-curr] || dp[i-1][j];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        int ans=0;
        for (int i=sum;i>=0;i--){
            if (dp[n-1][i]== true){
                ans=i;
                break;
            }
        }
        return total-2*ans;  
    }
}