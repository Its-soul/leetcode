class Solution(object):
    def largestOddNumber(self, nums):
        right = len(nums) - 1
        while right >= 0:
            if int(nums[right]) % 2 == 1:
                return nums[:right+1]
            right -= 1
        return ""
