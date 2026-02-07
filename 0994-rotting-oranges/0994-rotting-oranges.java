class Solution {
    static int rolen;
    static int colen;
    static int [] dr={-1,1,0,0};
    static int [] dc= {0,0,-1,1};
    int max_time= 0;
    static class Pair{
        int row;
        int col;
        int time;
        public Pair(int row, int col, int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        rolen= grid.length;
        colen= grid[0].length;
        // boolean [][] vis= new boolean [rolen][colen];
        int fresh=0;
        Queue<Pair> qu= new LinkedList<>();
        for(int i=0; i<rolen; i++){
            for(int j= 0; j<colen; j++){
                if(grid[i][j]==2){
                    qu.offer(new Pair(i,j,0));
                }
                else if( grid[i][j]==1) fresh++;
            }
        }
        if(fresh == 0){
            return 0;
        }

        while(!qu.isEmpty()){
            Pair curr= qu.poll();
            int r= curr.row;
            int c= curr.col;
            int time= curr.time;
            max_time= Math.max(max_time, time);
            for(int i=0; i<4;i++){
                int nR= r+dr[i];
                int nC= c+dc[i];

                if(nR>=0 && nC>=0 && nR<rolen && nC<colen && grid[nR][nC]==1){
                    grid[nR][nC]=2;
                    fresh--;
                    qu.offer(new Pair(nR, nC, time+1));
                }
            }
        }
        return (fresh==0)?max_time:-1;
    }
}