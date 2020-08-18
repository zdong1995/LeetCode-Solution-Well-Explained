class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums.length;
        }
        int slow = 2; // [0, slow) will be returned
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 2]) { // not more than twice duplicates
                nums[slow++] = nums[fast];
            }
        }
        return slow; // slow = last one index + 1
    }
}