class Solution:
    def totalNumbers(self, digits: List[int]) -> int:
        n = len(digits)
        result = set()

        for i in range(n):
            for j in range(n):
                for k in range(n):

                    if i == j or i == k or j == k:
                        continue

                    if digits[i] == 0:
                        continue

                    if digits[k] % 2 != 0:
                        continue

                    num = digits[i] * 100 + digits[j] * 10 + digits[k]
                    result.add(num)

        return len(result)