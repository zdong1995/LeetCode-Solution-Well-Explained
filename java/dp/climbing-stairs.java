class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] ways = new int[n + 1]; // store how many ways we can climb to i-th level
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
            // 1 step: (i-1)th level -> ith level, ways1 = ways[i - 1]
            // 2 steps: (i-2)th level -> ith level, ways2 = ways[i - 2]
        }
        return ways[n];
    }
}

// Two variable Memoization
class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // store how many ways we can climb to i-th level
        int waysSingle = 2; // 1 step: (i-1)th level -> ith level
        int waysDouble = 1; // 2 steps: (i-2)th level -> ith level
        int waysTop = 0;
        for (int i = 3; i <= n; i++) {
            waysTop = waysSingle + waysDouble;
            waysDouble = waysSingle;
            waysSingle = waysTop;
        }
        return waysTop;
    }
}