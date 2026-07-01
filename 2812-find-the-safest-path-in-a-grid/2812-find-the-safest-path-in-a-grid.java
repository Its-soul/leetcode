class Solution {
    class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<Pair> qu = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    qu.offer(new Pair(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        while (!qu.isEmpty()) {
            Pair node = qu.poll();
            int row = node.row;
            int col = node.col;

            for (int i = 0; i < 4; i++) {
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < n && dist[nRow][nCol] == -1) {
                    dist[nRow][nCol] = dist[row][col] + 1;
                    qu.offer(new Pair(nRow, nCol));
                }
            }
        }

        int low = 0, high = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                high = Math.max(high, dist[i][j]);

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(dist, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean isPossible(int[][] dist, int mid) {
        int n = dist.length;

        if (dist[0][0] < mid)
            return false;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.offer(new Pair(0, 0));
        vis[0][0] = true;

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;

            if (row == n - 1 && col == n - 1)
                return true;

            for (int i = 0; i < 4; i++) {
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < n && !vis[nRow][nCol] && dist[nRow][nCol] >= mid) {
                    vis[nRow][nCol] = true;
                    q.offer(new Pair(nRow, nCol));
                }
            }
        }

        return false;
    }
}