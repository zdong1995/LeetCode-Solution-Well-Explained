class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) { // include equal to handle corner case
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1; // mid = left can't be used here, otherwise may endless loop
            } else {
                right = mid - 1; // mid = right can't be used here, otherwise may endless loop
            }
        }
        return -1; // not found
    }
}