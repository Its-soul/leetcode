from collections import defaultdict

class Solution:
    def distance(self, nums):
        pos = defaultdict(list)

        for i, x in enumerate(nums):
            pos[x].append(i)

        ans = [0] * len(nums)

        for arr in pos.values():
            n = len(arr)
            pref = [0] * (n + 1)

            for i in range(n):
                pref[i + 1] = pref[i] + arr[i]

            for i in range(n):
                left = arr[i] * i - pref[i]
                right = (pref[n] - pref[i + 1]) - arr[i] * (n - i - 1)
                ans[arr[i]] = left + right

        return ans