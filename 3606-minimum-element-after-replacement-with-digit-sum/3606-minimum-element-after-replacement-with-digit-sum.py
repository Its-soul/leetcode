class Solution(object):
    def minElement(self, nums):
        min_val = float('inf')
        for x in nums:
            s = 0
            # use a while loop to compute digit sum
            while x > 0:
                s += x % 10
                x //= 10
            if s < min_val:
                min_val = s
        return min_val