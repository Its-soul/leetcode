class Solution(object):
    def nextBeautifulNumber(self, n):
        def is_balanced(num):
            s = str(num)
            for d in s:
                if s.count(d) != int(d):
                    return False
            return True

        num = n + 1
        while True:
            if is_balanced(num):
                return num
            num += 1