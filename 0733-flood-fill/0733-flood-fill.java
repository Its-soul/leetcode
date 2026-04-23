class Solution {
    int [] dr = {1,-1,0,0};
    int [] dc = {0,0,-1,1};
    int n;
    int m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n = image.length;
        m = image[0].length;
        int original= image[sr][sc];
        if(original==color) return image;
        helper(image, sr,sc, color, original);
        return image;
    }
    public void helper(int[][]image, int i, int j, int color, int original){
        if(i<0 || j<0 || i>=n || j>=m || image[i][j]!=original) return;
        image[i][j]=color;
        for(int k=0; k<4; k++){
            helper(image, i+dr[k], j+dc[k], color, original);
        }
    }
}