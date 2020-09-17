class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> list, TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        list.add(root.val);
        helper(list, root.left);
        helper(list, root.right);
    }
}