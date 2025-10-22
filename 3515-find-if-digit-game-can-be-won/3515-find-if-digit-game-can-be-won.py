class Solution(object):
    def canAliceWin(self, nums):
        single_digi_sum=0
        double_digi_sum=0
        for i in nums:
            if i<=9:
                single_digi_sum+=i
            else:
                double_digi_sum+=i
        if single_digi_sum != double_digi_sum:
            return True
        else:
            return False
