class Solution(object):
    def resultArray(self, nums, k):
        res = [0] * k
        cnt = [0] * k
        for num in nums:
            cnt2 = [0] * k
            for i in range (k):
                cnt2[ i * num % k] += cnt[i]
                res[ i * num % k] += cnt[i]
            cnt =  cnt2
            cnt[num % k] += 1
            res[num % k] += 1
        return res
        