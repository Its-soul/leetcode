class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int crr = 1;

        for (int idx = 0; idx < seq.length(); idx++) {
            char bracket = seq.charAt(idx);

            if (bracket == '(') {
                ans[idx] = 1 - crr;
            } else {
                ans[idx] = crr;
            }

            crr ^= 1;
        }

        return ans;
    }
} 