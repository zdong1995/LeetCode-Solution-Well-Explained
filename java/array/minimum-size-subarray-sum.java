class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0; // start of subarray
        int right = 0; // end of subarray window
        while (right < nums.length) {
            sum += nums[right];
            right++; // expand window
            
            while (sum >= s) { // match restriction
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                left++; // shrink subarray window
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}