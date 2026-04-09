class Solution {

    static int mod= 1000000007;
    Integer [][] dp;
    public int knightDialer(int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=9; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(4);
        adj.get(0).add(6);
        adj.get(1).add(6);
        adj.get(1).add(8);
        adj.get(2).add(7);
        adj.get(2).add(9);
        adj.get(3).add(4);
        adj.get(3).add(8);
        adj.get(4).add(3);
        adj.get(4).add(9);
        adj.get(4).add(0);
        adj.get(6).add(0);
        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(7).add(2);
        adj.get(7).add(6);
        adj.get(8).add(1);
        adj.get(8).add(3);
        adj.get(9).add(2);
        adj.get(9).add(4);

        int count=0;
        for(int i=0; i<=9; i++){
            dp= new Integer[10][n+1];
            for(int j=0; j<10; j++){
                dp[j][1] = 1;
            }
            count=(count+helper(i, n, adj))%mod;
        }
        return count%mod;

    }

    public int helper(int i, int n, ArrayList<ArrayList<Integer>> adj){
        if(n==0){
            return 1;
        }
        if(dp[i][n]!=null) return dp[i][n];
        int ans=0;
        if(!adj.get(i).isEmpty()){
            for(int k:adj.get(i)){
                ans = (ans+helper(k, n-1, adj))%mod;
            }
        }
        return dp[i][n]=ans%mod;
    }
}