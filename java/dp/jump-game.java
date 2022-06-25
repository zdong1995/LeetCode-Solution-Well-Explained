class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        boolean[] dp = new boolean[n + 1]; // to make more intuitive
        // dp[i] represent whether we can jump starting from current index to reach end
        dp[n] = true; // base case
        for (int i = n - 1; i >= 1; i--) { // grow up problem size by 1 each time
            // enumerate all possible destinations that can reach from current index
            int furthest = Math.min((i + nums[i - 1]), n); // avoid ArrayOutOfBoundary
            for (int j = furthest; j >= i; j--) {
                // j represent jump length, the corresponding jump length of index-i is i-1
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[1]; // the solution should be bool starting from 1st position
    }
}