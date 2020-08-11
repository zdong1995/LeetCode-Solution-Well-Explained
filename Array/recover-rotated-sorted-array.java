class Solution {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            // find first number that is larger than the next one
            // e.g. [4, 5, 1, 2, 3] -> find 2
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i); // [5, 4, 1, 2, 3]
                reverse(nums, i + 1, nums.size() - 1); // [5, 4, 3, 2, 1]
                reverse(nums, 0, nums.size() - 1); // [1, 2, 3, 4, 5]
            }
        }
    }
    
    private void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            int tmp = nums.get(start);
            nums.set(start++, nums.get(end));
            nums.set(end--, tmp);
        }
    }
}