class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // fix nums[i] to find 2 sum pairs > nums[i] in range [0, i-1]
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    // then the pairs in [left, rigth] will > nums[i]
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}