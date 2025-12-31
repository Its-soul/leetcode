class Solution(object):
    def checkSubarraySum(self, nums, k):
        rem = {0: -1}
        total = 0
        i = 0
        while i < len(nums):
            total += nums[i]
            if k != 0:
                total %= k
            if total in rem:
                if i - rem[total] > 1:
                    return True
            else:
                rem[total] = i
            i += 1
        return False