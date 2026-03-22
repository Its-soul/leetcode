class Solution {
    static int[] tree;
    static int[] arr;
    static int size;

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums1[i] - nums2[i];
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int x : arr) {
            set.add(x);
            set.add(x + diff);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for (int x : set) {
            map.put(x, idx++);
        }

        size = idx;
        tree = new int[4 * size];

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int left = 1;
            int right = map.get(arr[i] + diff);

            ans += query(0, 1, size, left, right);

            update(0, 1, size, map.get(arr[i]));
        }

        return ans;
    }

    public static void update(int index, int left, int right, int pos) {
        if (left == right) {
            tree[index] += 1;
            return;
        }
        int mid = (left + right) / 2;
        if (pos <= mid) {
            update(2 * index + 1, left, mid, pos);
        } else {
            update(2 * index + 2, mid + 1, right, pos);
        }
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    public static int query(int index, int left, int right, int ql, int qr) {
        if (left > qr || right < ql) return 0;
        if (ql <= left && right <= qr) return tree[index];

        int mid = (left + right) / 2;
        return query(2 * index + 1, left, mid, ql, qr)
             + query(2 * index + 2, mid + 1, right, ql, qr);
    }
}