class Solution {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int max=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,helper(grid,vis,i,j));
            }
        }
        return max;
    }
    public int helper(int[][] grid,boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }
        if(vis[i][j]==true){
            return 0;
        }
        vis[i][j]=true;
        int left=helper(grid,vis,i,j-1);
        int right=helper(grid,vis,i,j+1);
        int up=helper(grid,vis,i-1,j);
        int down=helper(grid,vis,i+1,j);
        vis[i][j]=false;
        return grid[i][j]+Math.max(left,Math.max(right,Math.max(up,down)));
    }
}