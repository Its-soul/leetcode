class Solution(object):
    def maxOperations(self, s):
        ones = 0
        count = 0
        prev = None
        
        for char in s:
            if char == '1':
                ones += 1
            else:
                if prev == '1':
                    count += ones
            prev = char
        
        return count
