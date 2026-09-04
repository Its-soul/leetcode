class Solution(object):
    def firstStableIndex(self, nums, k):
        for i in range (len(nums)):
            maxx = max(nums[:i+1])
            minn = min(nums[i:])
            if abs(minn - maxx)<= k:
                return i
        return -1