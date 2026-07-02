class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;

        int[] parent = new int[n];
        int[] size = new int[n];
        long[] sum = new long[n];
        boolean[] active = new boolean[n];
        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        long max = 0;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = max;

            int idx = removeQueries[i];
            active[idx] = true;
            sum[idx] = nums[idx];

            if (idx > 0 && active[idx - 1]) {
                union(idx, idx - 1, parent, size, sum);
            }

            if (idx < n - 1 && active[idx + 1]) {
                union(idx, idx + 1, parent, size, sum);
            }

            max = Math.max(max, sum[find(idx, parent)]);
        }

        return ans;
    }

    public int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    public void union(int x, int y, int[] parent, int[] size, long[] sum) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px == py) {
            return;
        }
        if (size[px] < size[py]) {
            parent[px] = py;
            size[py] += size[px];
            sum[py] += sum[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
            sum[px] += sum[py];
        }
    }
}