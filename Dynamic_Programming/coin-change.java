class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] num = new int[amount + 1];
        // num[i] represents how many coins need to make up amount = i
        num[0] = 0; // base case
        for (int i = 1; i <= amount; i++) {
            num[i] = Integer.MAX_VALUE; // initialize as can't make up
            // enumarate all possible coins
            for (int coin : coins) {
                if (coin <= i && num[i - coin] != Integer.MAX_VALUE) {
                    num[i] = Math.min(num[i], num[i - coin] + 1);
                    // add one more coin
                }
            }
        }
        return num[amount] == Integer.MAX_VALUE ? -1 : num[amount];
    }
}