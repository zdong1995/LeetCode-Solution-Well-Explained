class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        // for each bit, find whether the bit of ans is 1
        for (int i = 0; i < 32; i++) {
            int numOfOneBit = 0;
            for (int num : nums) {
                numOfOneBit += ((num >> i) & 1);
            }
            // if numOfOneBit % 3 == 1, means current bit of the single number is 1
            // update the value of current bit
            ans |= ((numOfOneBit % 3) << i);
        }
        return ans;
    }
}