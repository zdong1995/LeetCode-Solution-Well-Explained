class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[60]; // time duration % 60
        // modelling problem: find number of dual pairs in remainder that sum to 60
        int count = 0; // number of pairs
        for (int duration : time) {
            int remain = duration % 60;
            if (remain == 0) { // can pair with any duration that % 60 = 0
                count += remainder[0];
            } else { // find pair that equals to complement of cur remain
                count += remainder[60 - remain];
            }
            remainder[remain]++; // update count of cur remain
        }
        return count;
    }
}