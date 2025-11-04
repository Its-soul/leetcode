class Solution(object):
    def findXSum(self, nums, k, x):
        n=len(nums)
        res=[]
        for i in range(n-k+1):
            new_arr=nums[i:i+k]
            count = Counter(new_arr)
            items = list(count.items())
            items.sort(key=lambda item: (item[1], item[0]), reverse=True)
            top_items = items[:x]
            total = 0
            for num, freq in top_items:
                total += num * freq
            res.append(total)
        return res