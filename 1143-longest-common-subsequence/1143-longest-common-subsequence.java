class Solution {
    int n;
    int m;
    Integer [][] dp;
    public int longestCommonSubsequence(String t1, String t2) {
        n= t1.length()-1;
        m= t2.length()-1;
        dp = new Integer[n+1][m+1];
        int ans= helper(t1, t2, n, m);
        return ans;
    }

    public int helper(String t1, String t2, int i, int j){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(t1.charAt(i)==t2.charAt(j)){
            return 1+ helper(t1, t2, i-1, j-1);
        }
        else{
            return dp[i][j]=Math.max(helper(t1, t2, i-1, j), helper(t1, t2, i, j-1));
        }
    }
}