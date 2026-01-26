class Solution(object):
    def rotateElements(self, nums, k):
        non_neg = []
        for x in nums:
            if x >= 0:
                non_neg.append(x)
        if len(non_neg) == 0:
            return nums
    
        k = k % len(non_neg)
        rot = non_neg[k:] + non_neg[:k]
        index = 0
        for i in range(len(nums)):
            if nums[i] >= 0:
                nums[i] = rot[index]
                index += 1
        
        return nums