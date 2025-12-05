class Solution {
    public int findDuplicate(int[] nums) {
        int curr = nums[0];
        int next = nums[nums[0]];
        while (curr != next) {
            curr = nums[curr];
            next = nums[nums[next]];
        }
        curr = 0;
        while (curr != next) {
            curr = nums[curr];
            next = nums[next];
        }

        return curr;
    }
}
