class Solution {
    static int [] dr= {-1,1,0,0};
    static int [] dc= {0,0,1,-1};
    public void solve(char[][] board) {
        int rowl= board.length;
        int coll= board[0].length;
        boolean [][] vis = new boolean[rowl][coll];
        for (int i=0; i<rowl; i++) {
            for (int j= 0; j<coll; j++) {
                if ((i==0 || j==0 || i==rowl-1 || j==coll-1)&& board[i][j]=='O'){
                    dfs(i, j,board, vis);
                }
            }
        }
        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] board, boolean[][] vis){
        int rowl= board.length;
        int coll= board[0].length;
        if(i<0 || j<0 || i>=rowl|| j>=coll || board[i][j]=='X') return;
        if(vis[i][j]==true) return;
        vis[i][j]=true;
        for(int k= 0; k<4; k++){
            dfs(i+dr[k], j+dc[k], board,vis);
        }  
    }
}