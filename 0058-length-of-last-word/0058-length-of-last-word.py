class Solution(object):
    def lengthOfLastWord(self, s):
        s=s.split()
        return len(str(s[-1]))
        