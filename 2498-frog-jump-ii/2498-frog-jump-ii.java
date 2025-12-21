class Solution {
    public int maxJump(int[] st) {
        int n =st.length;
        int maxx = Math.abs(st[0]-st[1]);

        for(int i=2; i<n; i++){
            maxx = Math.max(maxx, Math.abs(st[i]-st[i-2]));
        }
        return maxx;
    }
}