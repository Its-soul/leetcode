class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n= nums.length;
        Arrays.sort(nums);
        int [] dp = new int[n];
        int [] parent = new int [n];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        int maxx= 1;
        int lastIndex = 0;

        for(int curr= 1; curr<n; curr++){
            for(int prev=0; prev<curr; prev++){
                if(nums[curr]%nums[prev]==0 && dp[curr]<dp[prev]+1){
                    dp[curr]= dp[prev]+1;
                    parent[curr]=prev;
                }
            }
            if (maxx<dp[curr]){
                maxx=dp[curr];
                lastIndex = curr;
            }
        }
        for(int i=lastIndex; i!=-1; i = parent[i]){
            res.add(nums[i]);
        }
        Collections.reverse(res);
        return res;
    }
}