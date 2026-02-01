from math import comb

class Solution:
    def getProbability(self, balls):
        n = len(balls)
        half = sum(balls) // 2
        dp = {}

        def dfs(i, d1, d2, s1, s2):
            key = (i, d1, d2, s1, s2)
            if key in dp:
                return dp[key]

            if i == n:
                res = (int(d1 == d2 and s1 == s2 == half), 1)
                dp[key] = res
                return res

            good = total = 0
            for k in range(balls[i] + 1):
                if s1 + k > half or s2 + balls[i] - k > half:
                    continue

                g, t = dfs(i + 1, d1 + (k > 0), d2 + (balls[i] - k > 0), s1 + k, s2 + balls[i] - k)
                w = comb(balls[i], k)
                good += g * w
                total += t * w

            dp[key] = (good, total)
            return dp[key]

        good, total = dfs(0, 0, 0, 0, 0)
        return good / total
