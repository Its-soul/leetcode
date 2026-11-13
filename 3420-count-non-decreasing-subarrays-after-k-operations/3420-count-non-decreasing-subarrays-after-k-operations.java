
class Solution {
    public long countNonDecreasingSubarrays(int[] a, int k) {
        int n = a.length;

        int left = 0;
        int right = n - 1;
        int top = 0;

        int[] stack = new int[n];

        long cost = 0;
        long result = 0;

        for (int i = n - 1; i >= 0; i--) {

            while (top > left && a[stack[top - 1]] <= a[i]) {
                int p = stack[top - 1];

                top--;

                int prev = right + 1;

                if (top > left) {
                    prev = stack[top - 1];
                }

                cost += (long) (a[i] - a[p]) * (prev - p);
            }

            stack[top] = i;
            top++;

            while (cost > k) {
                cost -= a[stack[left]] - a[right];

                right--;

                if (right < stack[left]) {
                    left++;
                }
            }

            result += right - i + 1;
        }

        return result;
    }
}
