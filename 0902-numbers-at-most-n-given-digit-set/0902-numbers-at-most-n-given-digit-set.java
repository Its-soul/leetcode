class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s= String.valueOf(n);
        int mask = 0;
        Integer [][][] dp = new Integer [s.length()][2][2];
        for(int i=0; i<digits.length;i++){
            mask=(1<<(digits[i].charAt(0)-'0')| mask);
        }
        return helper(s,0,1, mask,1, dp)-1; // string, index, tight, leading zero
    }
    public int helper(String s, int i, int tight, int mask, int lz,Integer [][][] dp){
        if (i==s.length()) return 1;
        int res = 0;
        int lb =0;
        int ub = (tight==1)? s.charAt(i)-'0':9;
        if (dp[i][tight][lz]!=null) return dp[i][tight][lz];
        for (int j =lb; j<=ub; j++){
            int newTight= (tight==1 && j ==ub) ?1:0;
            int isDigitUsed = (mask>>j) & 1;
            if (lz==1 && j==0) {
                res+=helper(s, i+1, newTight, mask, lz, dp);
            }
            else{
                if (isDigitUsed == 0) continue;
                else {
                    res+=helper(s, i+1, newTight, mask, 0, dp);
                }
            }
        }
        return dp[i][tight][lz] = res;
    }
}