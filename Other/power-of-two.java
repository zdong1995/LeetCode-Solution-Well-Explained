class Solution {
    public boolean isPowerOfTwo(int n) {
       // all number which is power of two will only contain one 1-bit
       if (countOfOnes(n) == 1) {
           return true;
       } else {
           return false;
       }
    }
    
    private int countOfOnes(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
}