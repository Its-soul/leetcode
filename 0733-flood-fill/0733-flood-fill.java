class Solution {
    // up= -1,0, down=1,0, right= 0,1, left= 0,-1; 
    static int [] dr= {-1,1,0,0};
    static int [] dc= {0,0,1,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sc_color= image[sr][sc];
        int rowl= image.length;
        int coll= image[0].length;
        boolean [][] vis = new boolean[rowl][coll];
        dfs(sr, sc, image, color, vis, sc_color);
        return image;
        
    }
    public void dfs(int i, int j, int[][] image, int color, boolean[][] vis, int sc_color){
        int rowl= image.length;
        int coll= image[0].length;
        if(i<0 || j<0 || i>=rowl|| j>=coll || image[i][j]!=sc_color) return;
        if(vis[i][j]==true) return;
        vis[i][j]=true;
        image[i][j]=color;
        for(int k= 0; k<4; k++){
            dfs(i+dr[k], j+dc[k], image, color, vis, sc_color);
        }
    }
}