class Solution {
    public int minCost(int n, int[] cuts) {
        int [] arr= new int [cuts.length+2];
        Arrays.sort(cuts);
        arr[0]= 0;
        for(int i=1; i<=cuts.length; i++){
            arr[i]= cuts[i-1];
        }
        arr[cuts.length+1]=n;
        Integer [][] dp = new Integer [cuts.length+2][cuts.length+2];
        return helper(arr, 1, cuts.length, dp);
        
    }
    public int helper(int [] arr, int i, int j, Integer [][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int min=(int)1e9;
        for(int idx=i; idx<=j; idx++){
            int cost= arr[j+1] - arr[i-1]+ helper(arr, i, idx-1, dp)+ helper(arr, idx+1, j, dp);
            min= Math.min(min, cost);
        }
        return dp[i][j]= min;
    }
}