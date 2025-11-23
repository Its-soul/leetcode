class Solution(object):
    def firstMissingPositive(self, nums):
        i = 1
        nums = set(nums)
        while i in nums:
            i += 1
        return i
