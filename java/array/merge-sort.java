class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // allocate helper array to keep constant extra space
        int[] helper = new int[nums.length];
        mergeSort(nums, helper, 0, nums.length - 1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int[] helper, int start, int end) {
        // base case
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, helper, start, mid);
        mergeSort(nums, helper, mid + 1, end);
        merge(nums, helper, mid, start, end);
    }
    
    private void merge(int[] nums, int[] helper, int mid, int start, int end) {
        int left = start;
        int right = mid + 1;
        int index = start;
        // iteratively copy smaller to helper array
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                helper[index++] = nums[left++];
            } else {
                helper[index++] = nums[right++];
            }
        }
        // post-processing
        while (left <= mid) {
            helper[index++] = nums[left++];
        }
        while (right <= end) {
            helper[index++] = nums[right++];
        }
        // copy sorted array in helper to nums
        for (int i = start; i <= end; i++) {
            nums[i] = helper[i];
        }
    }
}