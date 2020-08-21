class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (visited.containsKey(diff)) {
                return new int[] {i, visited.get(diff)};
            }
            visited.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}