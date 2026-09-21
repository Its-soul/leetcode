class Solution(object):
    def convertTime(self, current, correct):
        h1, m1 = map(int, current.split(":"))
        h2, m2 = map(int, correct.split(":"))

        diff = h2 * 60 + m2 - (h1 * 60 + m1)

        ans = diff // 60
        diff %= 60

        ans += diff // 15
        diff %= 15

        ans += diff // 5
        diff %= 5

        ans += diff

        return ans