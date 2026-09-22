class Solution {

    int[][] segtree;
    int k;

    public void build(int[] nums, int node, int l, int r) {
        if (l == r) {
            int rem = nums[l] % k;
            segtree[node][rem] = 1;
            segtree[node][k] = rem;
            return;
        }

        int mid = (l + r) / 2;

        build(nums, node * 2, l, mid);
        build(nums, node * 2 + 1, mid + 1, r);

        merge(node);
    }

    public void merge(int node) {
        int[] left = segtree[node * 2];
        int[] right = segtree[node * 2 + 1];
        int[] curr = segtree[node];

        int mulL = left[k];

        curr[k] = (mulL * right[k]) % k;

        for (int i = 0; i < k; i++) {
            curr[i] = left[i];
        }

        for (int i = 0; i < k; i++) {
            curr[(mulL * i) % k] += right[i];
        }
    }

    public void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            Arrays.fill(segtree[node], 0);

            int rem = value % k;
            segtree[node][rem] = 1;
            segtree[node][k] = rem;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        merge(node);
    }

    public int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return segtree[node];
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        int[] left = query(node * 2, l, mid, ql, qr);
        int[] right = query(node * 2 + 1, mid + 1, r, ql, qr);

        int[] result = new int[k + 1];

        int mulL = left[k];

        result[k] = (mulL * right[k]) % k;

        for (int i = 0; i < k; i++) {
            result[i] = left[i];
        }

        for (int i = 0; i < k; i++) {
            result[(mulL * i) % k] += right[i];
        }

        return result;
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;

        int n = nums.length;
        segtree = new int[4 * n][k + 1];

        build(nums, 1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            int[] res = query(1, 0, n - 1, start, n - 1);

            ans[i] = res[x];
        }

        return ans;
    }
}