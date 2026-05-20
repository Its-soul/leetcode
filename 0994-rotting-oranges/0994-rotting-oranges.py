from collections import deque

class Solution(object):

    class Pair:
        def __init__(self, row, col, time):
            self.row = row
            self.col = col
            self.time = time

    dr = [1, -1, 0, 0]
    dc = [0, 0, -1, 1]

    def orangesRotting(self, grid):

        n = len(grid)
        m = len(grid[0])

        fresh = 0
        max_time = 0

        qu = deque()
        for i in range(n):
            for j in range(m):

                if grid[i][j] == 2:
                    qu.append(self.Pair(i, j, 0))

                elif grid[i][j] == 1:
                    fresh += 1

        if fresh == 0:
            return 0

        while qu:

            p = qu.popleft()

            row = p.row
            col = p.col
            time = p.time

            max_time = max(max_time, time)

            for i in range(4):

                nr = row + self.dr[i]
                nc = col + self.dc[i]

                if (0 <= nr < n and
                    0 <= nc < m and
                    grid[nr][nc] == 1):

                    grid[nr][nc] = 2
                    fresh -= 1

                    qu.append(self.Pair(nr, nc, time + 1))

        if fresh > 0:
            return -1

        return max_time