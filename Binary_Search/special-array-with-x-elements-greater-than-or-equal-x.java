class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        // treat index 0 first to avoid IndexOutOfBoundError
        if (nums[0] >= len) {
            return len;
        }
        int left = 1;
        int right = len - 1;
        // binary search to find the first position that
        // nums[i] >= len - i and nums[i - 1] < nums[i]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= len - mid) {
                if (nums[mid - 1] < len - mid) { // correct index
                    return len - mid;
                } else { // not the first position, shrink right bound
                    right = mid - 1;
                }
            } else { // otherwisem, shrink the left bound to increase nums[mid]
                left = mid + 1;
            }
        }
        return -1;
    }
}