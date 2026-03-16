class NumArray {

    int[] segTree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4 * n];
        build(0, nums, 0, n - 1);
    }

    public void build(int index, int[] nums, int left, int right) {
        if (left == right) {
            segTree[index] = nums[left];
            return;
        }

        int mid = left+(right-left)/2;
        build(2*index+1, nums, left, mid);
        build(2*index+2, nums, mid+1, right);
        segTree[index] = segTree[2*index+1] + segTree[2*index+2];
    }

    public void update(int idx, int val) {
        updateHelper(0, 0, n - 1, idx, val);
    }

    public void updateHelper(int index, int left, int right, int idx, int val) {
        if (left == right) {
            segTree[index] = val;
            return;
        }

        int mid = left + (right - left) / 2;
        if (idx <= mid) {
            updateHelper(2*index+1, left, mid, idx, val);
        } else {
            updateHelper(2*index+2, mid+1, right, idx, val);
        }
        segTree[index] = segTree[2*index+1] + segTree[2*index+2];
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    public int query(int index, int start, int end, int left, int right) {

        if (right < start || left > end) return 0;

        if (left <= start && end <= right) return segTree[index];

        int mid = start + (end - start) / 2;
        int leftSum = query(2 * index + 1, start, mid, left, right);
        int rightSum = query(2 * index + 2, mid + 1, end, left, right);

        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */