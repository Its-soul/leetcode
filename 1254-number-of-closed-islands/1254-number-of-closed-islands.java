class Solution {
    static int [] dr= {-1,1,0,0};// u, d, l,r;
    static int [] dc= {0,0,-1,1};
    public int closedIsland(int[][] grid) {
        int count=0;
        for(int i=0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if((i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) && grid[i][j]==0){
                    dfs(grid,i, j);
                }
            }
        }
        for(int i=1; i<grid.length; i++){
            for(int j =1; j<grid[0].length; j++){
                if(grid[i][j]==0){
                    dfs(grid,i, j);
                    count++;
                }
            }
        }
        return count;        
    }

    public static void dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length ) return;
        grid[i][j]=1;
        for(int k=0; k<4; k++){
            int nr= i+dr[k];
            int nc= j+dc[k];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==0){
                dfs(grid, nr, nc);
            }
        }
        return;
    }
}