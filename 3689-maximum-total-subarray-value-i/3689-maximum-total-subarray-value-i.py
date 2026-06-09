class Solution(object):
    def maxTotalValue(self, nums, k):
        maxx=max(nums)
        minn=min(nums)
        return k * (maxx-minn)