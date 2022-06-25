class Solution {
    public int hammingDistance(int x, int y) {
        int counter = 0;
        // 1. xor operation to x and y -> all 1-bits are different bits
        // 2. count 1-bits number using int 1 as mask, iteratively right shift the xor result
        for (int i = x ^ y; i != 0; i >>= 1) { // termination condition: no 1-bits -> i == 0
            counter += i & 1;
        }
        return counter;
    }
}