class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), target, 0, candidates);
        return res;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> curPath,
                     int target, int index, int[] candidates) {
        // base case
        if (index == candidates.length) {
            if (target == 0) {
                list.add(convert(candidates, curPath));
            }
            return;
        }
        
        // each level dfs for one candidate
        // curPath stores how many we will need for each candidates
        int limit = target / candidates[index];
        for (int i = 0; i <= limit; i++) { // i represent how many candidates[index] we will use
            curPath.add(i);
            dfs(list, curPath, target - i * candidates[index], index + 1, candidates);
            curPath.remove(curPath.size() - 1);
        }
    }
    
    private List<Integer> convert(int[] candidates, List<Integer> count) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            for (int j = 0; j < count.get(i); j++) {
                res.add(candidates[i]);
            }
        }
        return res;
    }
}