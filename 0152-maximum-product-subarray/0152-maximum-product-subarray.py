class Solution(object):
    def maxProduct(self, nums):
        res = nums[0]
        maxpro = nums[0]
        minpro = nums[0]
        
        i = 1
        while i < len(nums):
            if nums[i] < 0:
                maxpro, minpro = minpro, maxpro  
                
            maxpro = max(nums[i], maxpro * nums[i])
            minpro = min(nums[i], minpro * nums[i])
            
            if maxpro > res:
                res = maxpro
            i += 1
            
        return res
