class Solution {
    static int ans;
    static int n;
    static int m;
    static boolean [][][] vis;
    public int minCost(int[][] grid) {
        ans = Integer.MAX_VALUE;
        n= grid.length;
        m= grid[0].length;
        vis= new boolean [n][m][1024];
        dfs(0,0, grid, 0);
        return ans;
    }

    public static void dfs(int i, int j, int [][] grid, int xor){
        xor^= grid[i][j];

        if(vis[i][j][xor]) return;
        vis[i][j][xor]= true;
        
        if(i==n-1 && j ==m-1){
            ans= Math.min(ans, xor);
            return;
        }
        if(j+1<m){
            dfs(i,j+1, grid, xor);//right k liye
        
        }
        if(i+1< n){
            dfs(i+1, j, grid, xor); //down k liye
        }
    }
}