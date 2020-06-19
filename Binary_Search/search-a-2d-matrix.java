class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // mapping from 1D to 2D:
        // r = index / col, c = index % col
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        // left, right of 1D array -> left-up, right-down corner of 2D array
        int left = 0, right = row*col - 1;
        // classical binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int r = mid / col, c = mid % col;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}