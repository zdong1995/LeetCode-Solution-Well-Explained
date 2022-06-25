class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates); // make duplicates adjacent
        findCombination(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    // dfs: find subset from candidates to sum to target
    // level: how many candidates in the subset
    // branch: which candidate we will select in current level
    // index: the first candidate we can select in current level
    // never look back to avoid duplicates combinations
    private void findCombination(int[] candidates, int target, List<List<Integer>> res,
                                 List<Integer> combination, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue; // skip duplicate
            }
            if (candidates[i] > target) {
                break; // the candidates from i to the end will all be larger than target
            }
            combination.add(candidates[i]);
            findCombination(candidates, target - candidates[i], res, combination, i + 1);
            combination.remove(combination.size() - 1); // backtracking
        }
    }
}