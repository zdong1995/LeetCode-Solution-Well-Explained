class Solution {
    private static int target;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        target = sum / k; // target sum for each set
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, 0, k, 0, visited);
    }

    private boolean dfs(int[] nums, int curSum, int needs, int index, boolean[] visited) {
        if (curSum == target) {
            // need to re-initialze visited array for next search iteration
            return needs == 1 || dfs(nums, 0, needs - 1, 0, visited);
        }
        if (curSum > target || index == nums.length) {
            return false; // pruning
        }
        // has been selected during current search, skip current number
        if (visited[index]) {
            return dfs(nums, curSum, needs, index + 1, visited);
        }
        // select current index number to subset
        visited[index] = true;
        if (dfs(nums, curSum + nums[index], needs, index + 1, visited)) {
            return true;
        }
        visited[index] = false;
        
        // not select current index number to subset
        return dfs(nums, curSum, needs, index + 1, visited);
    }
}