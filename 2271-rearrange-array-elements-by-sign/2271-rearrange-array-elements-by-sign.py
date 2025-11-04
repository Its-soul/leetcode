class Solution(object):
    def rearrangeArray(self, nums):
        pos=[]
        neg=[]
        res=[]
        for i in nums:
            if i>=0:
                pos.append(i)
            else:
                neg.append(i)

        for i in range(len(nums)/2):
            res.append(pos[i])
            res.append(neg[i])
        return res