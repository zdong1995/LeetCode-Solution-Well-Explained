class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] represent the length of longest increasing subarray in [0, i] 
        int[] dp = new int[nums.length];
        dp[0] = 1; // base case
        int longest = 1;
        // induction rule
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { // strictly increasing
                dp[i] = dp[i - 1] + 1;
            } else { // stop increasing at nums[i]
                dp[i] = 1;
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}