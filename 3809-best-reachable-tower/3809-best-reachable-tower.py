class Solution:
    def bestTower(self, towers: List[List[int]], center: List[int], radius: int) -> List[int]:
        ans = [-1, -1]
        best = -1
        cx, cy = center

        for x, y, q in towers:
            if abs(x - cx) + abs(y - cy) <= radius:
                if q > best:
                    best = q
                    ans = [x, y]
                elif q == best:
                    if x < ans[0] or (x == ans[0] and y < ans[1]):
                        ans = [x, y]
        return ans
