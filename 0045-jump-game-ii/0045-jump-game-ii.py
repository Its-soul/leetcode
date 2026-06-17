class Solution:
    def jump(self, nums):
        length = len(nums)
        if length <= 1:
            return 0
        jumps = 0
        curr = 0
        end = 0
        for i in range(length - 1):
            end = max(end, i + nums[i])
            
            if i == curr:
                jumps += 1
                curr = end
                if curr >= length - 1:
                    break
        
        return jumps
