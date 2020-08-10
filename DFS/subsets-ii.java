class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        List<Integer> curSet = new ArrayList<Integer>();
        findSubsets(nums, result, curSet, 0);
        return result;
    }
    
    private void findSubsets(int[] nums, List<List<Integer>> result, List<Integer> curSet, int index) {
        // base case
        if (index == nums.length) {
            result.add(new ArrayList(curSet));
            return;
        }
        // case 1: add nums[index]
        curSet.add(nums[index]);
        findSubsets(nums, result, curSet, index + 1);
        curSet.remove(curSet.size() - 1);
        
        /* skip all the rest of duplicate numbers
         * e.g. [1, 2, 2], index = 1
         *                       curSet=[1]
         *               add(2)  /       \  not
         *            curSet=[1, 2]      curSet=[1]    <- skip all the rest 2
         *        add(2)  /   \  not
         *  curSet=[1, 2, 2]  curSet=[1, 2] <- skip all the rest 2
         */
        
        while (index < nums.length - 1 && nums[index + 1] == nums[index]) {
            index++;
        }
        
        // case 2: don't add nums[index]
        findSubsets(nums, result, curSet, index + 1);
    }
}