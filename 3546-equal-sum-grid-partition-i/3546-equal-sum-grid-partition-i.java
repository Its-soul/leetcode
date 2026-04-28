class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long rsum= 0;
        long lsum=0;
        long total=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                total+=grid[i][j];
            }
        }
        if(total%2!=0) return false;
        if(n==1){
            for(int i=0; i<n; i++){
                rsum+=grid[i][0];
                if(total-rsum==rsum) return true;
            }
        }
        if(m==1){
            for(int j=0; j<m; j++){
                lsum+=grid[0][j];
                if(total-lsum==lsum) return true;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                rsum+=grid[i][j];
                if(total-rsum==rsum){
                    return true;
                }
            }
        }
        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                lsum+=grid[i][j];
                if(total-lsum==lsum){
                    return true;
                }
            }
        }
        return false;
    }
}