class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int start, int end) {
        // base case
        if (start >= end) { // avoid IndexOutOfBoundsException
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }
    
    private int partition(int[] nums, int start, int end) {
        // pick one random pivot
        int pivot = start + (int) (Math.random() * (end - start + 1));
        int tmp = nums[pivot];
        swap(nums, pivot, end); // swap pivot to rightmost first
        // maintain two pointer to partition the array
        int left = start; // [start, left): < tmp (exclusive left)
        int right = end - 1; // (right, end]: >= tmp (exclusive right)
        while (left <= right) {
            if (nums[left] < tmp) {
                left++;
            } else if (nums[right] >= tmp) { //  find the fisrt avaiable index to swap left and right
                right--;
            } else { // nums[left] >= tmp && nums[right] < tmp
                swap(nums, left++, right--);
            }
        }
        // termination: left = right + 1
        swap(nums, left, end); // swap pivot back to the middle
        return left; // now the left will be the pivot index
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}