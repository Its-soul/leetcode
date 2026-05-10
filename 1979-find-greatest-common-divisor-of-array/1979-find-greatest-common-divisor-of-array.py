class Solution(object):
    def findGCD(self, nums):
        minn= min(nums)
        maxx= max(nums)

        while maxx!=0:
            temp = maxx
            maxx= minn % maxx
            minn= temp

        return minn