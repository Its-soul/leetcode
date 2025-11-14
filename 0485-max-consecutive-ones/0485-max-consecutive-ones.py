class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        count=0
        maxx=0
        for i in nums:
            if i ==1:
                count+=1
                maxx=max(maxx,count)
            else:
                count=0
        return maxx