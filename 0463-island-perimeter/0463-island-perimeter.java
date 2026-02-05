class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean [][] vis= new boolean[grid.length][grid[0].length];
        int maxx=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    maxx=dfs(grid, vis, i, j);
                    break;
                }
            }
        }
        return maxx;
                
    }
    public int dfs(int[][] grid, boolean[][] vis, int i, int j) {
        if (i<0 || j<0 || i>= grid.length || j>= grid[0].length || grid[i][j]== 0) return 1;
        if (vis[i][j]) return 0;
        vis[i][j]= true;
        int count= 0;

        count+=dfs(grid, vis, i + 1, j);
        count+=dfs(grid, vis, i - 1, j);
        count+=dfs(grid, vis, i, j + 1);
        count+=dfs(grid, vis, i, j - 1);
        return count;
    }
}