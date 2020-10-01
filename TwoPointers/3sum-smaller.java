class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return count;
    }
    
    private int twoSumSmaller(int[] nums, int start, int target) {
        int pairs = 0;
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                // fix left + another number in (left, right]
                // then all the sum will be smaller than target
                pairs += right - left;
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }
}