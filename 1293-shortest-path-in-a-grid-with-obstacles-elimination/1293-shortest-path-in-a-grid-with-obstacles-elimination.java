class Solution {
    static int [] dr= {-1,1,0,0};
    static int [] dc= {0,0,-1,1};
    static int n;
    static int m;
    static class Pair{
        int row;
        int col;
        int step;
        int obs;
        public Pair(int row, int col, int step, int obs){
            this.row=row;
            this.col= col;
            this.step=step;
            this.obs= obs;
        }
    }    
    public int shortestPath(int[][] grid, int k) {
        n= grid.length;
        m= grid[0].length;
        int [][] dist= new int [n][m];
        for(int i =0; i<n; i++){
            Arrays.fill(dist[i], (int)1e9);
        }
    Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(0, 0, 0, grid[0][0]));
        dist[0][0] = 0;
        while (!qu.isEmpty()) {
            Pair curr = qu.poll();
            int r = curr.row;
            int c = curr.col;
            int cstep = curr.step;
            int cobs= curr.obs;
            if (r==n-1 && c==m-1) return cstep;
            if(cobs > dist[r][c]) continue;
            for (int i = 0; i < 4; i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                if (nr>=0 && nc>=0 && nr<n && nc<m) {
                    int newObs = cobs+grid[nr][nc];
                    if (newObs<=k && newObs < dist[nr][nc]) {
                        dist[nr][nc]=newObs;
                        qu.add(new Pair(nr, nc, cstep+1, newObs));
                    }
                }
            }
        }
        return -1;
    }
}