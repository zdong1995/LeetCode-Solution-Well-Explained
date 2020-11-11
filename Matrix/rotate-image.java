class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        matrixRotate(matrix, 0, matrix.length);
    }
    
    private void matrixRotate(int[][] matrix, int offset, int size) {
        // base case
        if (size <= 1) {
            return;
        }

        int end = offset + size - 1;
        // [0][0] ←  [0][n-1] ← [n-1][n-1] ← [n-1][0]
        for (int i = 0; i < size - 1; i++) {
            int temp = matrix[offset][offset + i]; // a
            // d → a
            matrix[offset][offset + i] = matrix[end - i][offset];
            // c → d
            matrix[end - i][offset] = matrix[end][end - i];
            // b → c
            matrix[end][end - i] = matrix[offset + i][end];
            // tmp → b
            matrix[offset + i][end] = temp;
        }
        
        matrixRotate(matrix, offset + 1, size - 2);
    }
}