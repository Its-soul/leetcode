public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        return helper(matrix, target, 0, matrix[0].length - 1);
    }
    private boolean helper(int[][] matrix, int target, int row, int col) {
        if (row >= matrix.length || col < 0) {
            return false;
        }
        if (matrix[row][col] == target) {
            return true;
        }
        if (target < matrix[row][col]) {
            return helper(matrix, target, row, col - 1);
        }
        return helper(matrix, target, row + 1, col);
    }
}
