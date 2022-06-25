class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // maintain 3 pointers to partition 3 areas
        int zero = 0; // [0, zero) are all 0s (exclusive zero)
        int one = 0; // [zero, one) are all 1s (exclusive zero)
        int two = nums.length - 1; // (two, n-1] are all 2s (exclusive two)
        // move one to traverse [one, two] area
        while (one <= two) {
            if (nums[one] == 0) { // case 1
                // swap 0 to [0, zero) area
                swap(nums, one++, zero++);
            } else if (nums[one] == 1) { // case 2
                one++;
            } else {
                swap(nums, one, two--);
                // do not one++, we need to check the new nums[one] again
            }
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}