class Solution(object):
    def findMissingElements(self, nums):
        min_int = min(nums)
        max_int = max(nums)
        num_set = set()
        sorted_values = []
        next_num = min_int + 1
        for num in nums:
            num_set.add(num)
        for i in range(min_int,max_int):
            if next_num not in num_set:
                sorted_values.append(next_num)
            next_num += 1
        return sorted_values