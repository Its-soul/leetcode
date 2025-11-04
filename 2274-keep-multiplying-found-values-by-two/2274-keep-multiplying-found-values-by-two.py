class Solution(object):
    def findFinalValue(self, nums, original):
        if original not in nums:
            return original
        return self.findFinalValue(nums,original*2)        

        