# class Solution(object):
#     def firstStableIndex(self, nums, k):
#         for i in range (len(nums)):
#             maxx = max(nums[:i+1])
#             minn = min(nums[i:])
#             if abs(minn - maxx)<= k:
#                 return i
#         return -1

class Solution(object):
    def firstStableIndex(self, nums, k):

        n = len(nums)
        suffix_min = [0] * n
        suffix_min[-1] = nums[-1]
        maxx = float('-inf')

        for i in range(n - 2, -1, -1):
            suffix_min[i] = min(nums[i], suffix_min[i + 1])

        for i in range(n):
            maxx = max(maxx, nums[i])
            minn = suffix_min[i]
            if maxx - minn <= k:
                return i
                
        return -1