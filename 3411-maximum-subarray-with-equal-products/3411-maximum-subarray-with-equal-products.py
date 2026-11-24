class Solution:
    def maxLength(self, nums: List[int]) -> int:
        from math import lcm, gcd
        n = len(nums)
        maxi = -float('inf')

        for i in range(n):
            lm = nums[i]
            gd = nums[i]
            prod = nums[i]
            if prod == lm*gd:
                maxi = max(maxi, 1)
            for j in range(i+1, n):
                lm = lcm(lm, nums[j])
                gd = gcd(gd, nums[j])
                prod = prod*nums[j]
                if prod == lm*gd:
                    maxi = max(maxi, j-i+1)
        return maxi