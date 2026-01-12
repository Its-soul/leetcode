class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int s=cuts.length;
        int [] arr= new int [s+2];
        arr[0]=0;
        arr[s+1]= n;
        for(int i =1; i<=s;i++){
            arr[i]=cuts[i-1];
        }
        Integer [][] dp = new Integer [s+2][s+2];
        return helper(1,s,arr, dp);
    }
    public int helper(int i, int j, int [] arr, Integer [][] dp){
        int min= (int)1e9;
        if (i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        for(int idx=i;idx<=j; idx++){
            int cost= arr[j+1]-arr[i-1] +helper(i, idx-1, arr,dp)+helper(idx+1,j,arr,dp);
            min= Math.min(min, cost);
        }
        return dp[i][j]= min;
    }
}