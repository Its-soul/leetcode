class Solution:
    def totalFruit(self, fruits):
        last = {}
        left = 0
        ans = 0
        for right, fruit in enumerate(fruits):
            last[fruit] = right

            if len(last) > 2:
                rem = min(last, key=last.get)
                left = last[rem] + 1
                del last[rem]
            ans = max(ans, right - left + 1)
        return ans
