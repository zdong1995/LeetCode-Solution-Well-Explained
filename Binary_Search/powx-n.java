class Solution {
    public double myPow(double x, int n) {
        if (n == 0) { // base case
            return 1;
        }

        // n / 2 will handle n = -1 and n = 1 to base case
        double ans = myPow(x, n / 2); 
        
        if (n % 2 == 0) {
            return ans * ans;
        } else {
            return (n > 0) ? x * ans * ans : ans * ans * 1 / x;
        }   
    }
}