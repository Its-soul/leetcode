class Solution(object):
    def missingNumber(self, nums):
        n = len(nums)
        cal = (n + 1) * n // 2
        act = sum(nums)
        
        return  cal - act