class Solution {
    public int findMin(int[] nums) {
        // fint the first element that smaller that last element
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int last = nums[nums.length - 1];
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= last) { // search leftside to find the first position
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}