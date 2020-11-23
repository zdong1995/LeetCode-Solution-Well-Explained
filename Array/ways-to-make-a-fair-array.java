class Solution {
    public int waysToMakeFair(int[] nums) {
        // calculate the odd sum and even sum
        int oddSum = 0, evenSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }

        int ways = 0;
        int preOddSum = 0, preEvenSum = 0;
        // enumerate all possible index to remove
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) { // even index
                evenSum -= nums[i]; // update right even sum
                if (preOddSum + evenSum == preEvenSum + oddSum) {
                    ways++;
                }
                preEvenSum += nums[i]; // add even index i number to preEvenSum

            } else { // odd index
                oddSum -= nums[i]; // update right odd sum
                if (preOddSum + evenSum == preEvenSum + oddSum) {
                    ways++;
                }
                preOddSum += nums[i]; // add odd index i number to preOddSum
            }
        }
        return ways;
    }
}