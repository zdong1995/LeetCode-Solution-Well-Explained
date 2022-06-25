class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q) {
            return root;
        }
        // ask for values from left and right child
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // check condtion and determine what to return to upper level
        if (left != null && right != null) { // found LCA
            return root;
        }
        // left == null && right == null OR left == null && right != null
        // if left == null -> return right
        // no matter right == null OR right == TreeNode p/q
        return left == null ? right : left;
    }
}