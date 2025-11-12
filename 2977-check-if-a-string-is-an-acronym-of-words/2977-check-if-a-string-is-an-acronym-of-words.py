class Solution(object):
    def isAcronym(self, words, s):
        x = ""
        for i in words:
            x += i[0]
        return x==s
        