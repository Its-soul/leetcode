// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         return helper(text1, text2, text1.length()-1, text2.length()-1);
//     }
//     public int helper(String text1, String text2, int i, int j){
//         if(i<0 || j<0) return 0;
//         if (text1.charAt(i)==text2.charAt(j)){
//             return 1+helper(text1, text2, i-1, j-1);
//         }
//         else{
//           return Math.max(helper(text1, text2, i-1, j),helper(text1, text2, i-1, j));
//         }
//     }
// }

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        Integer[][] dp = new Integer[n][m];
        return helper(text1, text2, n-1, m-1,dp);
    }
    public int helper(String s1, String s2, int i, int j, Integer[][] dp) {
        if(i<0 || j<0) {
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j]= 1+helper(s1, s2, i-1, j-1, dp);
        }else {
            return dp[i][j]=Math.max(helper(s1, s2, i-1, j, dp), helper(s1, s2, i, j-1, dp));
        }
    }
}