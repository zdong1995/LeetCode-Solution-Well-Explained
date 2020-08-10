class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        List<Integer> curSet = new ArrayList<Integer>();
        findSubsets(nums, result, curSet, 0);
        return result;
    }
    
    private void findSubsets(int[] nums, List<List<Integer>> result, List<Integer> curSet, int index) {
        // for each integer, we have two choice: add to curSet; not add to curSet
        // index represent the index of integer we are considering whether add to curSet or not
        
        if (index == nums.length) { // base case
            result.add(new ArrayList(curSet)); // Caution! add a new copy of curSet, not the reference
            return;
        }
        
        // recursion rule
        
        // case1: add nums[index] to curSet
        curSet.add(nums[index]);
        findSubsets(nums, result, curSet, index + 1); // recurse to next level
        curSet.remove(curSet.size() - 1); // before back-track to previous level, recover the state
        
        // case2: not add nums[index] to curSet
        findSubsets(nums, result, curSet, index + 1);
    }
}