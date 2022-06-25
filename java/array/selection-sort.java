class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        // [0,i) represents the sorted part
        // terminate condition: i = n - 1, no need to operate on last element
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) { // find the global min for this iteration
                // terminate condition: j = n, have compared all the elements
                if (nums[j] <= nums[min]) {
                    min = j;
                }
            }
            // swap the global min to left most
            swap(nums, min, i);
        }
        return nums;
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}