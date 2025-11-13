class Solution(object):
    def largestAltitude(self, gain):
        current = 0
        best = 0
        for i in gain:
            current += i
            best = max(best, current)
        return best