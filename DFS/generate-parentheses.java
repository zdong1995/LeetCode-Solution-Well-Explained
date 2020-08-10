class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(sb, result, n, 0, 0);
        return result;
    }
    
    private void helper(StringBuilder sb, List<String> result, 
                        int n, int left, int right) {
        // left, right: number of left, right parentheses
        if (left == n && right == n) { // base case: left and right parentheses used out
            result.add(sb.toString());
            return;
        }
        
        // case 1: still have left parenthesis left, add '('
        if (left <= n) {
            sb.append('(');
            helper(sb, result, n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // case 2: still have left parenthesis need to be matched, add ')'
        if (left > right) {
            sb.append(')');
            helper(sb, result, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}