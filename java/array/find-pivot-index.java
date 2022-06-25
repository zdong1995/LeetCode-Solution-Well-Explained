class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0; // total sum
        for (int x : nums) {
            sum += x;
        }
        // increase prefixsum starting from left to find pivot
        int leftsum = 0;
        for (int i = 0; i < nums.length; ++i) {
            // left sum of pivot = right sum of pivot
            if (leftsum == sum - leftsum - nums[i]) {
                return i;
            }
            // if not, increase the prefix sum
            leftsum += nums[i];
        }
        return -1; // not find
    }
}