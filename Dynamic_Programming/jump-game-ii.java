class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int[] minJump = new int[n];
        // minJump[i] represent the min jumps we need to reach end from i-th position
        minJump[n - 1] = 0; // base case: last one elment no need to jump
        for (int i = n - 2; i >= 0; i--) { // grow problem size by 1 from right to left
            if (i + nums[i] >= n - 1) { // case 1: 1 step jump out of bound
                minJump[i] = 1;
            } else { // case 2: will not ArrayOutOfBoundError
                int min = Integer.MAX_VALUE;
                for (int j = nums[i]; j > 0; j--) { // enumerate all possible destinations to find Min
                    min = Math.min(min, minJump[i + j]);
                }
                minJump[i] = min + 1;
            }
        }
        return minJump[0];
    }
}