class Solution {

    public static final long mod = 1000000007L;

    long[] sum;
    long[] squares;
    long[] lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        squares = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];

            update(0, 0, n - 1, prev + 1, i, 1);

            ans = (ans + squares[0]) % mod;

            last[nums[i]] = i;
        }

        return (int) ans;
    }

    public void update(int index, int left, int right, int ql, int qr, long val) {
        if (left > qr || right < ql || ql > qr) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(index, left, right, val);
            return;
        }

        pushDown(index, left, right);

        int mid = left + (right - left) / 2;

        update(2 * index + 1, left, mid, ql, qr, val);
        update(2 * index + 2, mid + 1, right, ql, qr, val);

        sum[index] = (sum[2 * index + 1] + sum[2 * index + 2]) % mod;
        squares[index] = (squares[2 * index + 1] + squares[2 * index + 2]) % mod;
    }

    public void apply(int index, int left, int right, long val) {
        long len = right - left + 1;

        squares[index] = (squares[index]
                + 2L * val % mod * sum[index] % mod
                + val * val % mod * len % mod) % mod;

        sum[index] = (sum[index] + val * len) % mod;

        lazy[index] = (lazy[index] + val) % mod;
    }

    public void pushDown(int index, int left, int right) {
        if (lazy[index] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        apply(2 * index + 1, left, mid, lazy[index]);
        apply(2 * index + 2, mid + 1, right, lazy[index]);

        lazy[index] = 0;
    }
}