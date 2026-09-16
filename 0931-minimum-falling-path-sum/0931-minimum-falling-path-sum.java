class Solution {
    
    Integer dp[][];
    
    public int minFallingPathSum(int[][] matrix) {

        if (matrix.length == 1)
            return matrix[0][0];

        dp = new Integer[matrix.length][matrix[0].length];
        int ans = (int)1e9;
        for(int i = 0; i < matrix[0].length; i++){
            ans = Math.min(ans, helper(matrix, 0, i));
        }
        return ans;
    }

    public int helper(int grid[][], int i, int j){
        if (j < 0 || j >= grid[0].length)
            return (int)1e9;

        if (i == grid.length - 1)
            return grid[i][j];
        
        if(dp[i][j]!=null) return dp[i][j];

        int left_diagonal = grid[i][j] + helper(grid, i+1, j-1);
        int right_diagonal = grid[i][j] + helper(grid, i+1, j+1);
        int down = grid[i][j] + helper(grid, i+1, j);

        return dp[i][j] = Math.min(left_diagonal, Math.min(right_diagonal, down));
        
    }

}