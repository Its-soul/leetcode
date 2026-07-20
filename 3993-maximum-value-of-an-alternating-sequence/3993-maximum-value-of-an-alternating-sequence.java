class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n==1) return s;

        long peak1=(long)n/2;
        long ans1 = s;
        if(peak1>0){
            ans1 = (long)s+peak1*m-(peak1-1);
        }

        long peak2 = (n-1L)/2;
        long ans2 = (long)s+peak2*(m-1L);

        return Math.max(ans1, ans2);
    }
}