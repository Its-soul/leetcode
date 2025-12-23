class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int count=0;
        int end= -(int)1e9;
        for (int i = 0; i < pairs.length; i++) {
            int[] pair = pairs[i];
            if (pair[0] > end) {
                count++;
                end = pair[1];
            }
        }return count;
    }
}