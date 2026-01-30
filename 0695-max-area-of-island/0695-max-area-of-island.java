class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int maxx = 0;
        for (int i=0; i<n; i++) {
            for (int j= 0; j<m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int count= dfs(grid, vis, i, j);
                    maxx= Math.max(maxx, count);
                }
            }
        }return maxx;
    }

    public int dfs(int[][] grid, boolean[][] vis, int i, int j) {
        if (i<0 || j<0 || i>= grid.length || j>= grid[0].length) return 0;
        if (grid[i][j]== 0 || vis[i][j]) return 0;
        vis[i][j]= true;
        int count= 1;

        count+=dfs(grid, vis, i + 1, j);
        count+=dfs(grid, vis, i - 1, j);
        count+=dfs(grid, vis, i, j + 1);
        count+=dfs(grid, vis, i, j - 1);
        return count;
    }
}
