class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet()); // O(n)
        for (int num : nums) { // total O(n) -> every number will be removed once
            if (set.remove(num)) {
                int prev = num - 1; // previous number of current number in the sequence
                int next = num + 1; // next number in the sequence
                // continue expanding the sequence range
                while (set.remove(prev)) { // remove -> mark as visited
                    prev--;
                }
                while (set.remove(next)) {
                    next++;
                }
                // out of while loop condition: prev and next not in the sequence
                // thus the range of sequence is [prev + 1, next - 1]
                // length will be (next - 1) - (prev + 1) + 1 = next - prev - 1
                res = Math.max(next - prev - 1, res);
            }
        }
        return res;
    }
}