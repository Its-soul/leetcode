class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalMod = 0;
        for (int i = 0; i < n; i++) {
            totalMod = (totalMod + nums[i]) % p;
        }
        int target = totalMod % p;
        if (target == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = n;
        int prefixMod = 0;
        for (int i = 0; i < n; i++) {
            prefixMod = (prefixMod + nums[i]) % p;
            int needed = (prefixMod - target + p) % p;
            if (map.containsKey(needed)) {
                int length = i - map.get(needed);
                if (length < result) result = length;
            }map.put(prefixMod, i);
        }
        if (result == n) return -1;
        return result;
    }
}
