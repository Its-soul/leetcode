from collections import Counter
class Solution(object):
    def majorityElement(self, nums):
        result = Counter(nums).most_common(1)
        return result[0][0]