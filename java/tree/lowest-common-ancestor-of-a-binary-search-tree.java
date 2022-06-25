class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) {
            return root;
        }
        
        if (root.val < p.val && root.val < q.val) {
            // case 1: root.val < p.val && root.val < q.val -> p and q in root.right
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            // case 2: root.val > p.val && root.val > q.val -> p and q in root.left
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // case 3: root.val < p.val && root.val < q.val -> p and q in root.right
            return root;
        }
    }
}