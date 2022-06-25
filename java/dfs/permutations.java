class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> curPath, int[] nums, int index) {
        // index represented how many numbers we have used
        // base case
        if (index == nums.length) {
            result.add(new ArrayList(curPath));
            return;
        }
        
        // prev level: index = 0 -> 1 | 2 3
        // swap the letter to index-th position -> nums[0, index] will be sorted
        // cur level: index = 1 -> 1 2 | 3
        for (int i = index; i < nums.length; i++) { // iterate all possible states
            swap(nums, index, i); // make decision
            curPath.add(nums[index]); // add selected number to curPath result
            helper(result, curPath, nums, index  + 1);
            curPath.remove(curPath.size() - 1); // remove to recover state
            swap(nums, index, i); // swap back to recover the state
        }
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}