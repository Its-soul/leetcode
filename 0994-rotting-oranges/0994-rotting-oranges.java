class Solution {
    int [] dr= {1,-1,0,0};
    int [] dc= {0,0,-1,1};


    class Pair{
        int row;
        int col;
        int time;
        public Pair(int row, int col, int time){
            this.row=row;
            this.col=col;
            this.time= time;
        }
    }


    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max_time=0;
        int fresh=0;
        Queue<Pair> qu= new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    qu.offer(new Pair(i, j, 0));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if (fresh==0){
            return 0;
        }
        while(!qu.isEmpty()){
            Pair curr= qu.poll();
            int crow= curr.row;
            int ccol= curr.col;
            int time= curr.time;
            max_time= Math.max(time, max_time);
            for(int k=0; k<4; k++){
                int nr = crow + dr[k];
                int nc = ccol + dc[k];
                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                    qu.offer(new Pair(nr, nc, time+1));
                }
            }
        }
        return (fresh==0)?max_time:-1;
    }
}