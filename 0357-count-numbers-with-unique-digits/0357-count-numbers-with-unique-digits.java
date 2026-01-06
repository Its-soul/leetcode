class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int q= (int)Math.pow(10,n)-1;
        int range=(int)Math.pow(10,n);
        String s= String.valueOf(q);
        Integer [][][][][] dp = new Integer [10][2][2][1024][2];//[len][][][nmask][];
        int ans = helper(s,0,1,0,0,1, dp); //index, tight, repeted, mask, leading zero
        return range-ans;
    }
    public int helper(String s, int index, int tight, int repeted, int mask, int lz ,Integer[][][][][] dp){
        if (index==s.length()) return repeted;
        int lb = 0;
        int ub= (tight==1)?s.charAt(index)-'0':9;
        int res =0;
        if(dp[index][tight][repeted][mask][lz]!=null) return dp[index][tight][repeted][mask][lz];
        for(int i = lb; i<=ub; i++){
            int newTight = (tight==1 && i==ub)?1:0;
            if (lz==1 && i==0){
                res += helper(s, index+1, newTight, repeted, mask, lz, dp);
            }
            else{
                int isDigitUsed = 1 & (mask>>i);
                int newRepeted = (repeted==1 || isDigitUsed==1)?1:0;
                int newMask = (1<<i )| mask;
                res+=helper(s, index+1, newTight, newRepeted, newMask, 0, dp);
            }
        }
        return dp[index][tight][repeted][mask][lz]=res;
    }
}