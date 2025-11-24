class Solution(object):
    def sumAndMultiply(self, n):
        res=""
        multi=0
        for i in str(n):
            if i != '0':
                res+=i
                multi+=int(i)
        if res == "":
            return 0

        return int(res) * multi