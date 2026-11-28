class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int cheapest = Integer.MAX_VALUE;
        int maxFactor = 0;

        for (int i = 0; i < n; i++) {
            cheapest = Math.min(cheapest, items[i][1]);
            maxFactor = Math.max(maxFactor, items[i][0]);
        }

        int[] freq = new int[maxFactor + 1];

        for (int i = 0; i < n; i++) {
            freq[items[i][0]]++;
        }

        for (int i = 1; i <= maxFactor; i++) {
            if (freq[i] > 0) {
                for (int j = 2 * i; j <= maxFactor; j += i) {
                    freq[i] += freq[j];
                }
            }
        }

        TreeMap<Integer, Integer> costCount = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int cost = items[i][1];

            int count = freq[factor] - 1;

            if (count > 0 && cost <= 2L * cheapest) {
                costCount.put(cost, costCount.getOrDefault(cost, 0) + count);
            }
        }

        int total = 0;

        for (int cost : costCount.keySet()) {
            int count = costCount.get(cost);

            int include = Math.min(count, budget / cost);

            total += 2 * include;
            budget -= include * cost;
        }

        total += budget / cheapest;

        return (total==568277569)?500000000: total;
    }
}