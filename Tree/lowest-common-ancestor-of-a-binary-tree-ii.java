class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) { // sanity check
            return null;
        }
        TreeNode res = findLCA(root, p, q);
        if (res == p) { // search q in the subtree of p
            // if find q, that means p is LCA, otherwise return null
            return findLCA(p, q, q) != null ? res : null;
        } else if (res == q) {
            return findLCA(q, p, p) != null ? res : null;
        }
        return res; // (res != p && res != q) || res == null
    }

    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root; // current root is LCA
        }
        return left == null ? right : left;
    }
}