class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k > n) {
            return res;
        }
        dfs(res, new ArrayList<>(), n, k, 1);
        return res;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> curPath,
                     int n, int k, int index) {
        // base case
        if (index > n) {
            if (curPath.size() == k) {
                list.add(new ArrayList(curPath));
            }
            return;
        }
        
        // add current number
        curPath.add(index);
        dfs(list, curPath, n, k, index + 1);
        curPath.remove(curPath.size() - 1); // recover state
        
        // not add current number
        dfs(list, curPath, n, k, index + 1);
    }
}