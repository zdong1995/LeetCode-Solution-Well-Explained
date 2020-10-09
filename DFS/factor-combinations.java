class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 1) {
            return res;
        }
        // find all possible factors
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        // find all factors combinations
        dfs(res, new ArrayList<>(), factors, 0, n);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> cur,
                     List<Integer> factors, int index, int n) {
        // base case
        if (index == factors.size()) {
            if (n == 1) {
                res.add(new ArrayList(cur));
            }
            return;
        }
        
        // not select current factor
        dfs(res, cur, factors, index + 1, n);
        // recursion rule
        int count = 0; // represent how many times the factor been used
        int factor = factors.get(index);
        while (n % factor == 0) { // still can be divided
            cur.add(factor);
            count++;
            n /= factor;
            dfs(res, cur, factors, index + 1, n);
        }
        // backtrack recover state
        for (int i = 0; i < count; i++) {
            cur.remove(cur.size() - 1); // remove used factors in cur level
        }
    }
}