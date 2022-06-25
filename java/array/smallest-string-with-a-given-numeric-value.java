class Solution {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        // start from last position to set largest each time
        for (int i = n - 1; i >= 0; i--) {
            // the largest value if we set the prev i digits as 'a'
            int largest = k - i;
            // if largest >= 26, the largest we can set to current digit is only 'z'
            // if largest < 26, the largest we can set to current digit is largest
            int add = Math.min(largest, 26);
            res[i] = (char) (add - 1 + 'a');
            k -= add;
        }
        return new String(res);
    }
}