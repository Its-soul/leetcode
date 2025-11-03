class Solution(object):
    def lexPalindromicPermutation(self, s, target):
        from collections import Counter
        
        counts = Counter(s)
        n = len(s)

        odd_count = sum(v % 2 for v in counts.values())
        if (n % 2 == 0 and odd_count > 0) or (n % 2 == 1 and odd_count != 1):
            return ""

        res = ['a'] * n
        sorted_chars = sorted(counts.keys())

        def solve(i, is_greater):
            if i == (n + 1) // 2 - 1:
                if n % 2 == 1:
                    odd_char = [ch for ch in sorted_chars if counts[ch] == 1][0]
                    res[i] = odd_char
                elif n % 2 == 0:
                    remain_char = [ch for ch in sorted_chars if counts[ch] == 2][0]
                    res[i], res[i + 1] = remain_char, remain_char

                if is_greater:
                    return True
                for k in range(n):
                    if res[k] < target[k]:
                        return False
                    if res[k] > target[k]:
                        return True
                return False

            if not is_greater:
                chars = [c for c in sorted_chars if c >= target[i] and counts[c] > 1]
            else:
                chars = [c for c in sorted_chars if counts[c] > 1]

            for ch in chars:
                res[i] = ch
                res[n - i - 1] = ch
                counts[ch] -= 2
                new_is_greater = is_greater or (ch > target[i])

                if solve(i + 1, new_is_greater):
                    return True

                counts[ch] += 2

            return False

        if solve(0, False):
            return "".join(res)
        return ""
