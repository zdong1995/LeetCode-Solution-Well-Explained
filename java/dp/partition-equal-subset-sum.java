class Solution {
    public boolean canPartition(int[] nums) {
				int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd,it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) {
						return false;
				}
        int subSetSum = totalSum / 2;

        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
        return dfs(nums, 0, subSetSum, memo);
    }

    public boolean dfs(int[] nums, int index, int subSetSum, Boolean[][] memo) {
        // Base Cases
        if (subSetSum == 0) { // case 1: found the subsets to sum to totalSum / 2
		        return true;
				}
        if (index == nums.length || subSetSum < 0) { // case2: not found
            return false;
				}

        // check if subSetSum for given n is already computed and stored in memo
        if (memo[index][subSetSum] != null) {
            return memo[index][subSetSum];
				}
        boolean result = dfs(nums, index + 1, subSetSum - nums[index], memo) || 
												 dfs(nums, index + 1, subSetSum, memo);
        // store the result in memo
        memo[index][subSetSum] = result;
        return result;
    }
}