// class Solution {
//     public int numDistinct(String s, String t) {
//         return helper(s, t, 0, 0);
//     }
//     public int helper(String s, String t, int i, int j) {
//         if (j == t.length()) return 1;
//         if (i == s.length()) return 0;
//         int count = 0;
//         if (s.charAt(i) == t.charAt(j)) {
//             count += helper(s, t, i + 1, j + 1);
//         }
//         count += helper(s, t, i + 1, j);
//         return count;
//     }
// }




// class Solution {
//     Integer[][] dp;
//     public int numDistinct(String s, String t) {
//         dp = new Integer[s.length()][t.length()];
//         return helper(s, t, 0, 0);
//     }

//     public int helper(String s, String t, int i, int j) {
//         if (j == t.length()) return 1;
//         if (i == s.length()) return 0;
//         if (dp[i][j] != null) return dp[i][j];
//         int count = helper(s, t, i + 1, j);
//         if (s.charAt(i) == t.charAt(j)) {
//             count += helper(s, t, i + 1, j + 1); 
//         }return dp[i][j] = count;
//     }
// }

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n= t.length();
        int [][] dp = new int [m+1][n+1];
        for(int i= 0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int i= 1; i<=m;i++){
            for(int j =1; j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}