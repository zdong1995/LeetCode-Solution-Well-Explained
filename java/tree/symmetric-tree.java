class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
           return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true; // base case 1
        } else if (left == null || right == null) {
            return false; // base case 2
        } else if (left.val != right.val) {
            return false; // base case 3
        }
        /* check next layer
         *          left                     right
         *  left.left  left.right   right.left   right.right
         */
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}