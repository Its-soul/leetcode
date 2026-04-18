class Solution {
    boolean[][]vis;
    int count=0;
    public int numIslands(char[][] grid) {
        vis= new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'&& !vis[i][j]){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        if (i<0 || j<0 || i>= grid.length || j>= grid[0].length) return;
        if (grid[i][j]== '0' || vis[i][j]) return;
        vis[i][j]= true;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}