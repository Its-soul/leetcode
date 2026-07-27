class Solution(object):
    def maxProduct(self, nums):
        nums.sort()
        return max((nums[0]-1)*(nums[1]-1), (nums[-1]-1)*(nums[-2]-1))