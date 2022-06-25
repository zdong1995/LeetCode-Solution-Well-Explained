class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // sum[i] stores the largest sum of array ending at current index
        int[] sum = new int[nums.length];
        // base case
        sum[0] = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // induction rule: max between (previous max_sum + current num) and only current num itself
            sum[i] = Math.max(sum[i - 1] + nums[i], nums[i]);
            globalMax = Math.max(sum[i], globalMax);
        }
        return globalMax;
    }
}