class Solution(object):
    def processStr(self, s, k):
        length = 0

        for ch in s:
            if ch == '#':
                length *= 2
            elif ch == '*':
                if length > 0:
                    length -= 1
            elif ch == '%':
                pass
            else:
                length += 1

        if k >= length:
            return '.'

        for ch in reversed(s):
            if ch == '#':
                length //= 2
                k %= length

            elif ch == '%':
                k = length - 1 - k

            elif ch == '*':
                length += 1

            else:
                length -= 1
                if k == length:
                    return ch

        return '.'