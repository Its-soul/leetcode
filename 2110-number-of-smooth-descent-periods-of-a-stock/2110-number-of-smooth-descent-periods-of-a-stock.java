class Solution {
    public long getDescentPeriods(int[] prices) {
        return helper(prices, 1, 1, 1);
    }

    private long helper(int[] prices, int i, long total, int count) {
        if (i == prices.length) return total;
        if (prices[i] - prices[i - 1] == -1) {
            return helper(prices, i + 1, total + count + 1, count + 1);
        } else {
            return helper(prices, i + 1, total + 1, 1);
        }
    }
}
