// Iterative
class Solution {
    // Time: O(N)
    // Space: O(1)
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            } else if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
}

// Recursive
class Solution {
    // Time: O(N)
    // Space: O(height)
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) { // base case
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return null;
    }
}