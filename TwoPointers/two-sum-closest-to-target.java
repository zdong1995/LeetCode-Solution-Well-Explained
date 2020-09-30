public class Solution {
    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return 0;
            } else if (sum > target) {
                minDiff = Math.min(minDiff, sum - target);
                right--;
            } else {
                minDiff = Math.min(minDiff, target - sum);
                left++;
            }
        }
        return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
    }
}