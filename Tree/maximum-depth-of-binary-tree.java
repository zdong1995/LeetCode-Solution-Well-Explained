class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;  // base case
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); // recursion rule
    }
}