class Solution(object):
    def countCommas(self, n):
        if(n<=999):
            return 0
        return (n - 1000) + 1