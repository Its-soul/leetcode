class Solution {
    public int maxEnvelopes(int[][]arr) {
        if (arr == null ||arr.length == 0) 
        return 0;
        Arrays.sort(arr,(a,b) -> {
            if (a[0]!=b[0]) return a[0]-b[0];     
            return b[1]-a[1]; });                   
        int[] dp =new int[arr.length];
        int len = 0;

        for (int[] env:arr) {
            int h = env[1];
            int index = Arrays.binarySearch(dp,0,len,h);
            if (index<0) index =-(index+1);
            dp[index]=h;
            if (index==len) len++;
        }
        return len;
    }
}