class Solution(object):
    def missingMultiple(self, nums, k):
        i = 1
        while i<= 101:
            if k * i not in nums:
                return k * i
            i = i+1