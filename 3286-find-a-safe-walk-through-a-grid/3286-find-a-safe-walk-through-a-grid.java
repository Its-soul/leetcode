class Solution {
    static int[] dr = {-1,1,0,0}; 
    static int[] dc = {0,0,-1,1};
    static class Pair{
        int row;
        int col;
        int heal;
        public Pair(int row, int col, int heal){
            this.row=row;
            this.col= col;
            this.heal=heal;
        }
    } 
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], -1);
        }
        Queue<Pair> qu = new LinkedList<>();
        int cheal = health-grid.get(0).get(0);
        if(cheal <= 0) return false;
        dist[0][0] = cheal;
        qu.add(new Pair(0,0,cheal));
        while(!qu.isEmpty()){
            Pair curr = qu.poll();
            int r = curr.row;
            int c = curr.col;
            int val = curr.heal;
            if(r == n-1 && c == m-1){
                return true;
            }
            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int curHealth = val-grid.get(nr).get(nc);
                    if(curHealth > 0 && curHealth > dist[nr][nc]){
                        qu.add(new Pair(nr, nc, curHealth));
                        dist[nr][nc] = curHealth;
                    }
                }
            }
        }
        return false;
    }
}