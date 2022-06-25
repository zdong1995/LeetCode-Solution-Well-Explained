class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        // [prev1, prev2, cur] -> [0,1,1]
        int prev1 = 0;
        int prev2 = 1;
        int cur = 0;
        for (int i = 2; i < N + 1; i++) {
          // fibo(N) = fibo(N-2) + fibo(N-1)
          cur = prev1 + prev2;
          prev1 = prev2;
          prev2 = cur;
        }
        return cur;
    }
}