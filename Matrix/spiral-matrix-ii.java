class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        fillMatrix(res, n, 0, 1);
        return res;
    }
    
    // offset represent the x, y cooridinate of left-top element
    private void fillMatrix(int[][] matrix, int size, 
                            int offset, int num) {
        // base case
        if (size == 0) {
            return;
        }
        if (size == 1) {
            matrix[offset][offset] = num;
            return;
        }
        
        // fill top
        for (int i = 0; i < size - 1; i++) {
            matrix[offset][i + offset] = num++;
        }
        // fill right
        for (int i = 0; i < size - 1; i++) {
            matrix[offset + i][size - 1 + offset] = num++;
        }
        // fill down
        for (int i = size - 1; i > 0; i--) {
            matrix[size - 1 + offset][offset + i] = num++;
        }
        // fill left
        for (int i = size - 1; i > 0; i--) {
            matrix[offset + i][offset] = num++;
        }
        
        fillMatrix(matrix, size - 2, offset + 1, num);
    }
}