class Solution(object):
    def firstMissingPositive(self, nums):
        n = len(nums)
        for i in range(n):
            if nums[i] <= 0 or nums[i] > n:
                nums[i] = n + 1
        for num in nums:
            abNums = abs(num)
            if 1 <= abNums <= n:
                nums[abNums - 1] = -abs(nums[abNums - 1])
        for i in range(n):
            if nums[i] > 0:
                return i + 1
        return n + 1
