class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        return helper(matrix, target, 0, row * column - 1, column);
    }

    public boolean helper(int[][] matrix, int target, int left, int right, int column) {
        if (left > right) {
            return false;
        }
        int mid = left + (right - left) / 2;
        int r = mid / column;
        int c = mid % column;
        if (matrix[r][c] == target) {
            return true;
        } else if (matrix[r][c] > target) {
            return helper(matrix, target, left, mid - 1, column);
        } else {
            return helper(matrix, target, mid + 1, right, column);
        }
    }
}
