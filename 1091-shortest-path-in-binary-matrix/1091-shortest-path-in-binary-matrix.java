class Solution {
    static int rlen;
    static int clen;
    static int [] dr={-1,1,0,0,-1,-1,1,1};
    static int [] dc={0,0,-1,1,-1,1,1,-1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        Queue<int[]> q=new LinkedList<>();
        rlen=grid.length;
        clen=grid[0].length;
        q.add(new int[]{0,0,1});
        grid[0][0]=1;
        while(!q.isEmpty()){
            int [] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            int dis=curr[2];
            if(row==rlen-1 && col==clen-1){
                return dis;
            }
            for(int i=0;i<8;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(nrow>=0 && ncol>=0 && nrow<rlen && ncol<clen && grid[nrow][ncol]==0){
                    grid[nrow][ncol]=1;
                    q.add(new int[]{nrow,ncol,dis+1});              
                }
            }
        }
        return -1;
    }
}