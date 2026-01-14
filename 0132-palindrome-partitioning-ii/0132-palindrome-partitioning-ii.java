class Solution {
    public int minCut(String s) {
        Integer [] dp =  new Integer[s.length()];
        return helper(s,0,dp)-1;
    }
    public int helper(String s, int i, Integer[] dp){
        if (i==s.length()) return 0;
        if(dp[i]!=null) return dp[i];
        int min= (int)1e9;
        for(int j=i; j<s.length(); j++){
            if (ispalin(s,i,j)){
                int cost = 1+ helper(s,j+1,dp);
                min= Math.min(min, cost);
            }
        }
        return dp[i]=min;
    }
    public boolean ispalin(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}