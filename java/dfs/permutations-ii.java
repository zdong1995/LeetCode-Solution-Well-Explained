class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> curPath,
                        int[] nums, int index) {
        // index represented how many numbers we have used
        // base case
        if (index == nums.length) {
            result.add(new ArrayList(curPath));
            return;
        }
        // use one hash set to store numbers we haved used in current level
        Set<Integer> used = new HashSet<Integer>();
        // index is the first position we need to scan
        // the numbers before index are already used
        // index = 1                  [1, | 1,3,4]
        // swap                 /         |        \
        // index = 2  [1,1, | 3,4]  [1,3, | 1,4]   [1,4 | 3,1]
        for (int i = index; i < nums.length; i++) { // iterate all possible states
            // skip duplicates we have used before
            if (!used.contains(nums[i])) {
                used.add(nums[i]); // record current selected number
                swap(nums, index, i); // make decision
                curPath.add(nums[index]); // add selected number to curPath result
                dfs(result, curPath, nums, index  + 1);
                curPath.remove(curPath.size() - 1); // remove to recover state
                swap(nums, index, i); // swap back to recover the state
            }
        }
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}