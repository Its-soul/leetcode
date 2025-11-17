class Solution(object):
    def kLengthApart(self, nums, k):
        count = k 
        for i in range(len(nums)):
            if nums[i] == 1:
                if count < k:
                    return False
                count = 0
            else:
                count += 1
        return True
