from collections import Counter

class Solution:
    MAX = 10**6 + 1

    def smallestPalindrome(self, s: str, k: int) -> str:
        cnt = Counter(s)

        half = [0] * 26
        mid = ""

        for c, f in cnt.items():
            half[ord(c) - ord("a")] = f // 2
            if f & 1:
                mid = c

        if self.count(half) < k:
            return ""

        left = []
        m = sum(half)

        for _ in range(m):
            for i in range(26):
                if half[i] == 0:
                    continue

                half[i] -= 1
                ways = self.count(half)

                if ways >= k:
                    left.append(chr(i + ord("a")))
                    break

                k -= ways
                half[i] += 1

        left = "".join(left)
        return left + mid + left[::-1]

    def count(self, cnt):
        total = sum(cnt)
        ans = 1

        for x in cnt:
            if x:
                ans *= self.nCr(total, x)
                if ans >= self.MAX:
                    return self.MAX
                total -= x

        return ans

    def nCr(self, n, r):
        r = min(r, n - r)
        ans = 1

        for i in range(1, r + 1):
            ans = ans * (n - i + 1) // i
            if ans >= self.MAX:
                return self.MAX

        return ans