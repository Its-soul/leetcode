from collections import Counter

class Solution(object):
    def maxNumberOfBalloons(self, text):
        count = Counter(text)
        balloon = Counter("balloon")

        return min(count[ch] // balloon[ch] for ch in balloon)