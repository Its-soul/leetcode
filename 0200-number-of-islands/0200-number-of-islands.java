class Solution {
    static int [] dr= {-1,1,0,0};//up, dowm, left, right
    static int [] dc= {0,0,-1,1};
    public int numIslands(char[][] grid) {
        int count=0;
        boolean [][] vis= new boolean [grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid, boolean[][] vis, int i, int j){
        vis[i][j]=true;
        for(int k=0; k<4; k++){
            int nR= i+dr[k];
            int nC= j+dc[k];
            if(nR>=0 && nC>=0 && nR<grid.length && nC<grid[0].length && !vis[nR][nC] && grid[nR][nC]=='1'){
                dfs(grid, vis, nR, nC);
            }
        }
    }
}