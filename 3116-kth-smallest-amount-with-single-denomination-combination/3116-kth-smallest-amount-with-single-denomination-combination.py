class Solution:
    def findKthSmallest(self, coins: List[int], k: int) -> int:
        coins.sort()

        new_coins = []

        for x in coins:
            keep = True

            for y in new_coins:
                if x % y == 0:
                    keep = False
                    break

            if keep:
                new_coins.append(x)

        coins = new_coins

        n = len(coins)
        m = 1 << n

        lcm = [1] * m

        left = k
        right = coins[0] * k + 1

        for mask in range(1, m):
            prev_mask = mask & (mask - 1)

            lowest_bit = mask & -mask
            i = lowest_bit.bit_length() - 1

            temp = lcm[prev_mask] // gcd(
                lcm[prev_mask],
                coins[i]
            )

            if temp <= right // coins[i]:
                lcm[mask] = temp * coins[i]
            else:
                lcm[mask] = right + 1

        def get(x: int) -> int:
            count = 0

            for mask in range(1, m):
                if lcm[mask] > x:
                    continue

                if mask.bit_count() % 2 == 1:
                    count += x // lcm[mask]
                else:
                    count -= x // lcm[mask]

            return count

        while left < right:
            mid = (left + right) // 2

            if get(mid) >= k:
                right = mid
            else:
                left = mid + 1

        return left
        