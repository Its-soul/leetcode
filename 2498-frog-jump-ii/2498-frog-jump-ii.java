class Solution {
    public int maxJump(int[] st) {
        int n =st.length;
        int max = Math.abs(st[0]-st[1]);

        for(int i=2; i<n; i++){
            max = Math.max(max, Math.abs(st[i]-st[i-2]));
        }
        return max;
    }
}