class Solution {
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // for the negative sum of subtree, set to 0 -> not select into path
        int leftSum = Math.max(dfs(root.left), 0);
        int rightSum = Math.max(dfs(root.right), 0);
        
        // check whether current subtree are max path sum
        max = Math.max(leftSum + rightSum + root.val, max);
        
        // return the path with larger sum to upper level
        return root.val + Math.max(leftSum, rightSum);
    }
}