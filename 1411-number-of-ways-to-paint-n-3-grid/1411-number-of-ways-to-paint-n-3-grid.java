class Solution {
    public int numOfWays(int n) {
        long mod = 1000000007;
        long a = 6 ;
        long b = 6 ;
        for(int i = 1 ; i < n ; i++){
            long nexta = a*3 + b*2;
            long nextb = a*2 + b*2;
            a = nexta %mod;
            b = nextb % mod ;
        }
        return (int)((a+b)%mod);
    }
}