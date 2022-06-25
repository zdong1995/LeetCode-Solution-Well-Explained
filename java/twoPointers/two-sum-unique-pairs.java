public class Solution {
  public int twoSum6(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      Arrays.sort(nums);
      int count = 0;
      int left = 0;
      int right = nums.length - 1;
      while (left < right) {
          int sum = nums[left] + nums[right];
          if (sum == target) {
              count++;
              left++;
              right--;
              while (left < right && nums[left] == nums[left - 1]) {
                  left++;
              }
              while (left < right && nums[right] == nums[right + 1]) {
                  right--;
              }
          } else if (sum > target) {
              right--;
          } else {
              left++;
          }
      }
      return count;
  }
}