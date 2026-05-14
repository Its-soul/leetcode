class Solution(object):
    def isGood(self, nums):
        n= len(nums)
        nums.sort()
        if n!=max(nums)+1:
                return False
        for i in range(n-1):
            if nums[i]!=i+1:
                return False
        return True