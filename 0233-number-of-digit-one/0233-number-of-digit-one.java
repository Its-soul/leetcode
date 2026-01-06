class Solution {
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        Integer [][][]dp = new Integer [s.length()+1][2][11];
        return helper(s, 0, 1, 0, dp);

    }
    public int helper(String s, int i, int tight, int count, Integer [][][]dp){
        if (i==s.length()) return count;
        int lb= 0;
        int ub = (tight==1)?s.charAt(i)-'0':9;
        int res =0;
        if (dp[i][tight][count]!=null) return dp[i][tight][count];
        for(int j = lb; j<=ub; j++){
            int newTight = (tight==1 && j ==ub)?1:0;
            if (j==1){
                res += helper(s, i+1, newTight, count+1, dp);
            }
            else{
                res+=helper(s, i+1, newTight, count, dp);
            }
        }
        return dp[i][tight][count]=res;
    }
}