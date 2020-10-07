public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1); // if current bit is 1, then (1 & 1) -> 1
            n >>>= 1;
        }
        return count;
    }
}