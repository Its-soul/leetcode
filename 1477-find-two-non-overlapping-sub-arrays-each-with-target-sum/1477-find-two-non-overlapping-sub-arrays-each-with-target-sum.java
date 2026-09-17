class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int best[] = new int[n + 1];
        int left = 0;
        int sum = 0;
        int ans = (int)1e9;

        Arrays.fill(best, (int)1e9);
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            best[right + 1] = best[right];

            if (sum == target) {
                int current = right - left + 1;
                
                if (best[left] != (int)1e9) {
                    ans = Math.min(ans, current + best[left]);
                }
                best[right + 1] = Math.min(best[right + 1], current);
            }
        }

        return ans == (int)1e9 ? -1 : ans;
    }
}