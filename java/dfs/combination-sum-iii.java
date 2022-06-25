import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || n == 0) {
            return res;
        }
        findCombination(k, n, res, new ArrayList<>(), 0);
        return res;
    }

    // dfs: find size k subsets from [1,2,...9] that sums to n
    // level: how many numbers selected
    // branch: which number to select
    // never look back, to avoid duplicates
    private void findCombination(int k, int n, List<List<Integer>> res,
                                 List<Integer> combination, int index) {
        if (n == 0 && combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }
        // index: the first number we can choose
        // add current number, number at index will be index + 1
        //   num = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        // index = [0, 1, 2, 3, 4, 5, 6, 7, 8]
        for (int i = index; i <= 8; i++) {
            if (index + 1 > n) { // failure, will not find a candidate
                break;
            }
            combination.add(i + 1); // index 0 -> number 1
            findCombination(k, n - i - 1, res, combination, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}