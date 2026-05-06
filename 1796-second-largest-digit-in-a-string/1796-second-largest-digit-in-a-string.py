class Solution(object):
    def secondHighest(self, s):
        count = 0
        for i in "9876543210":
            if i in s:
                if count==1:
                    return int(i)
                count+=1
        return -1