class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // base case
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.val != root2.val) {
            return false;
        }
        /* 
         *         one                    two
         *  one.left  one.right   two.left   two.right
         *  check next layer whether same tree OR symmetric tree
         */
        return (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
                || (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right));
    }
}