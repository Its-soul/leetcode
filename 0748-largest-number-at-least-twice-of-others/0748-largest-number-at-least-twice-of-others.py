class Solution(object):
    def dominantIndex(self, nums):
        if not nums:
            return -1

        first = second = float('-inf')
        for i in nums:
            if i > first:
                second = first
                first = i
            elif i > second:
                second = i

        if first >= 2 * second:
            return nums.index(first)
        else:
            return -1
