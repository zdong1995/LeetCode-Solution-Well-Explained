public class Solution {
    public int twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                count += right - left;
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}