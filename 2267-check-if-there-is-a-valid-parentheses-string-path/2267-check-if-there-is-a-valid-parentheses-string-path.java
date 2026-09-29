class Solution {

    class Pair{
        int row;
        int col;
        int val;

        Pair(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if((m+n)%2==0) return false;
        if(grid[0][0]==')' || grid[m-1][n-1]=='(') return false;

        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='('){
                    arr[i][j] = 1;
                }
                else{
                    arr[i][j] = -1;
                }
            }
        }

        boolean[][][] visited = new boolean[m][n][(m+n)/2+1];

        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(0, 0, 1));
        visited[0][0][1] = true;

        int[] dr = {1, 0};
        int[] dc = {0, 1};

        while(!qu.isEmpty()){
            Pair curr = qu.poll();

            int crow = curr.row;
            int ccol = curr.col;
            int val = curr.val;

            if(crow==m-1 && ccol==n-1){
                if(val==0) return true;
                continue;
            }

            for(int k=0; k<2; k++){
                int nrow = crow + dr[k];
                int ncol = ccol + dc[k];

                if(nrow<m && nrow>=0 && ncol<n && ncol>=0){
                    int nval = val + arr[nrow][ncol];

                    int remaining = (m-1-nrow) + (n-1-ncol);

                    if(nval>=0 && nval<=remaining && !visited[nrow][ncol][nval]){
                        visited[nrow][ncol][nval] = true;
                        qu.offer(new Pair(nrow, ncol, nval));
                    }
                }
            }
        }

        return false;
    }
}
