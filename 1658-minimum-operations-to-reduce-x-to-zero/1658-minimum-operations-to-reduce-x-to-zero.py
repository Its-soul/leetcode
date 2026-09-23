class Solution(object):
    def minOperations(self, nums, x):
        total = sum(nums)
        target = total - x

        if target == 0:
            return len(nums)

        left = 0
        curr = 0
        maxLen = -1

        for right in range(len(nums)):
            curr += nums[right]

            while left <= right and curr > target:
                curr -= nums[left]
                left += 1

            if curr == target:
                maxLen = max(maxLen, right - left + 1)

        if maxLen == -1:
            return -1

        return len(nums) - maxLen