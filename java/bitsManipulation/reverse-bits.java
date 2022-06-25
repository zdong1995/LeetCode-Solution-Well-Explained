public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) { 
        // corner case all 0 or all 1
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int temp = (n >> i) & 1; // mask leftshift -> hamming weight = 1
            res |= temp << (31 - i);
        }
        return res;
    }
}