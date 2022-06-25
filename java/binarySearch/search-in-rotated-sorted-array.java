class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[left]) { // leftside is rotated
                if (target < nums[left] && target > nums[mid]) {
                    left = mid + 1; // search in sorted part
                } else {
                    right = mid - 1; // search in rotated part
                }
            } else { // leftside is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // search in sorted part
                } else {
                    left = mid + 1; // search in rotated part
                }
            }
        }
        return -1;
    }
}