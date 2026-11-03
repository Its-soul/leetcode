class Solution(object):
    def minMoves(self, nums):
        maxx = max(nums)
        ans = 0
        for i in nums:
            if i != maxx:
                ans += (maxx - i)
        return ans
