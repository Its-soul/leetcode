class Solution {

    int[] len;
    char[] first;
    char[] last;
    int[] pre;
    int[] suff;
    char[] arr;


    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();

        len = new int[4 * n];
        first = new char[4 * n];
        last = new char[4 * n];
        pre = new int[4 * n];
        suff = new int[4 * n];

        build(0, 0, n - 1);

        int[] ans = new int[queryCharacters.length()];

        for (int i = 0; i < queryCharacters.length(); i++) {

            update(0, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));

            ans[i] = len[0];
        }

        return ans;
    }


    public void build(int node, int l, int r) {

        if (l == r) {

            len[node] = 1;
            first[node] = arr[l];
            last[node] = arr[l];
            pre[node] = 1;
            suff[node] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        build(2 * node + 1, l, mid);
        build(2 * node + 2, mid + 1, r);

        merge(node, 2 * node + 1, 2 * node + 2, l, r);
    }


    public void merge(int node, int left, int right, int l, int r) {

        len[node] = Math.max(len[left], len[right]);

        first[node] = first[left];
        last[node] = last[right];

        pre[node] = pre[left];
        suff[node] = suff[right];

        int mid = l + (r - l) / 2;

        if (last[left] == first[right]) {

            len[node] = Math.max(len[node], suff[left] + pre[right]);

            if (pre[left] == mid - l + 1) {
                pre[node] = pre[left] + pre[right];
            }

            if (suff[right] == r - mid) {
                suff[node] = suff[left] + suff[right];
            }
        }
    }


    public void update(int node, int l, int r, int idx, char ch) {

        if (l == r) {

            len[node] = 1;
            first[node] = ch;
            last[node] = ch;
            pre[node] = 1;
            suff[node] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        if (idx <= mid) {
            update(2 * node + 1, l, mid, idx, ch);
        } else {
            update(2 * node + 2, mid + 1, r, idx, ch);
        }

        merge(node, 2 * node + 1, 2 * node + 2, l, r);
    }


    public int[] query(int node, int l, int r, int ql, int qr) {

        if (r < ql || l > qr) {
            return null;
        }

        if (ql <= l && r <= qr) {
            return new int[]{len[node], pre[node], suff[node]};
        }

        int mid = l + (r - l) / 2;

        int[] left = query(2 * node + 1, l, mid, ql, qr);
        int[] right = query(2 * node + 2, mid + 1, r, ql, qr);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        int best = Math.max(left[0], right[0]);

        return new int[]{best, left[1], right[2]};
    }
}