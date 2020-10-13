class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0; // insert at start
        }
        int left = 0;
        int right = nums.length - 1;
        // find closest position
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) { 
                left = mid;
            } else {
                right = mid;
            }
        }
        int closest = Math.abs(nums[left] - target) <= Math.abs(nums[right] - target) ? left : right;
        if (nums[closest] < target) {
            // closest is the last position that < target, insert at next position
            return closest + 1;
        } else {
            // closest is target or greater than target, insert at closest
            return closest;
        }
    }
}