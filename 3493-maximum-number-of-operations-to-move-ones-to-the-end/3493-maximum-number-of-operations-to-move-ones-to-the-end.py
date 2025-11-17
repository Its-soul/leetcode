class Solution(object):
    def maxOperations(self, s):
        ones = 0
        count = 0
        n = len(s)
        for i in range(n):
            if s[i] == '1':
                ones += 1
            else:
                if i > 0 and s[i-1] == '1':
                    count += ones
        return count
