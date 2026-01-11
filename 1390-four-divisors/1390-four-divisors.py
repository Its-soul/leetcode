class Solution(object):
    def sumFourDivisors(self, nums):
        total = 0
        for n in nums:
            res = set()
            j = 1

            while j * j <= n:
                if n % j == 0:
                    res.add(j)
                    res.add(n // j)
                if len(res) > 4:
                    break
                j += 1
            if len(res) == 4:
                total += sum(res)
        return total
