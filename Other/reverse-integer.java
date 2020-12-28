class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int curDigit = x % 10;
            x /= 10;
            int newNum = res * 10 + curDigit;
            // if overflow, newNum will be flipped to negative
            // newNum - curDigit != 10 * res
            if ((newNum - curDigit) / 10 != res) {
                return 0;
            }
            res = newNum;
        }
        return res;
    }
}