// recursion
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) { // base case
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        // delink to avoid loop
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
// iterative
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode next = null;
        TreeNode prev = null;
        TreeNode prevRight = null;
        while (cur != null) {
            next = cur.left;
            cur.left = prevRight; // connect to prev right child
            prevRight = cur.right; // update prevRight for next root
            cur.right = prev;
            
            prev = cur;
            cur = next;
        }
        return prev;
    }
}