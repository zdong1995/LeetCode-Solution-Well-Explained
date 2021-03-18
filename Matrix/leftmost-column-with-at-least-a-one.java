/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0) - 1, col = dimensions.get(1) - 1;
        // starting from bottom right corner
        while (row >= 0 && col >= 0) {
            if (binaryMatrix.get(row, col) == 1) { // search left
                col--;
            } else { // search up
                row--;
            }
        }
        if (col == dimensions.get(1) - 1) { // all 0s matrix case, col never changes
            return -1;
        }
        // finally stop at the all 0s column left to the leftMost 1s column
        return col + 1; // leftMost 1s column should be final col + 1
    }
}