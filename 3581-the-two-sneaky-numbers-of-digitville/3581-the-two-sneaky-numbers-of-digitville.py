from collections import Counter
class Solution(object):
    def getSneakyNumbers(self, nums):
        count= Counter(nums)
        res=[]
        for i,j in count.items():
            if j>1:
                res.append(i)
        return res