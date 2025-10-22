class Solution(object):
    def combinationSum(self, nums, target):
        res = []

        def backtrack(start, path, total):
            if total == 0:
                res.append(path[:])
                return
            if total < 0:
                return

            for i in range(start, len(nums)):
                path.append(nums[i])
                backtrack(i, path, total - nums[i])
                path.pop()

        backtrack(0, [], target)
        return res
