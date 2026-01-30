class Solution {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j= 0; j<m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, vis, i, j);
                    count++;
                }
            }
        }return count;
    }

    public void dfs(char[][] grid, boolean[][] vis, int i, int j) {
        if (i<0 || j<0 || i>= grid.length || j>= grid[0].length) return;
        if (grid[i][j]== '0' || vis[i][j]) return;
        vis[i][j]= true;

        dfs(grid, vis, i + 1, j);
        dfs(grid, vis, i - 1, j);
        dfs(grid, vis, i, j + 1);
        dfs(grid, vis, i, j - 1);
    }
}
