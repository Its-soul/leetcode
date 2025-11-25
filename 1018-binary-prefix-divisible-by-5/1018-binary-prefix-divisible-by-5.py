class Solution(object):
    def prefixesDivBy5(self, nums):
        res = []
        mod = 0
        for i in nums:
            mod = (mod * 2 + i) % 5
            res.append(mod == 0)
        return res
