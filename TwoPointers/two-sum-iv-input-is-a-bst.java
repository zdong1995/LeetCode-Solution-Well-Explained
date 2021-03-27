class Solution {
    // HashSet
    // Time: O(n), Space: O(n)
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return dfs(root, k, new HashSet<>());

    }

    private boolean dfs(TreeNode root, int k, Set<Integer> seen) {
        // base case
        if (root == null) {
            return false;
        }
        // check whether complement of current root.val has been traversed
        if (seen.contains(k - root.val)) {
            return true;
        }
        seen.add(root.val);
        // search left and right subtree
        return dfs(root.left, k, seen) || dfs(root.right, k, seen);
    }

    // Two Pointers
    // Time: O(nlogn), Space: O(1)
    public boolean findTarget2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        TreeNode start = root;
        TreeNode end = root;
        while (start.left != null) { // left most is the smallest in BST
            start = start.left;
        }
        while (end.right != null) { // right most is the largest in BST
            end = end.right;
        }
        while (start != end) {
            int sum = start.val + end.val;
            if (sum > k) {
                end = findPredecessor(root, end);
            } else if (sum < k) {
                start = findSuccessor(root, start);
            } else {
                return true;
            }
        }
        return false;
    }
    
    private TreeNode findPredecessor(TreeNode root, TreeNode node) {
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < node.val) {
                pre = cur;
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return pre;
    }
    private TreeNode findSuccessor(TreeNode root, TreeNode node) {
        TreeNode succ = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > node.val) {
                succ = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return succ;
    }
}
