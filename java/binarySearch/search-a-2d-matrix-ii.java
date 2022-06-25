class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 
            || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        // smallest: M[0][0], largest: M[rowNum][colNum]
        // find middle: M[rowNum][0]
        int row = rowNum - 1;
        int col = 0;
        while (row >= 0 && col <= colNum - 1) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                // target will be in the top rows of current
                row--; // find largest smaller than target
            } else {
                // target will be in the right cols of current
                col++; // find first larger than target
            }
        }
        return false;
    }
}