class Solution:
    def stoneGameIX(self, stones: List[int]) -> bool:
        counts = [0, 0, 0]
        
        for stone in stones:
            counts[stone % 3] += 1
            
        c0, c1, c2 = counts[0], counts[1], counts[2]
        
        if c0 % 2 == 0:
            return c1 >= 1 and c2 >= 1
        else:
            return abs(c1 - c2) >= 3