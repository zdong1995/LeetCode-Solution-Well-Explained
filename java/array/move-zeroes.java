class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int slow = 0; // [0, slow) are all non-0s (exclusive)
        for (int fast = 0; fast < nums.length; fast++) { // fast will traverse the whole array
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast]; // copy non-0s to the left of slow
            }
        }
        // all the non-0s are at the begining
        // fill 0s from left to end
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

// swap solution: similar like sort colors
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int slow = 0; // [0, slow) are all non-0s (exclusive slow)
        int fast = 0; // [slow, fast) are all 0s (exclusive fast)
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(nums, slow++, fast++); // swap non-0 and 0, then update boundary
            } else {
                fast++; // just update boundary
            }
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}