class Solution:
    def digitSum(self, s, k):
        while len(s) > k:
            new_s = ''
            i = 0
            while i < len(s):
                group = s[i:i+k]
                total = 0
                for d in group:
                    total += int(d)
                new_s += str(total)
                i += k
            s = new_s
        return s
