class Solution(object):
    def checkString(self, s):
        if "b" not in s:
            return True
        return 'a' not in s[s.index('b'):]