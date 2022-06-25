class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {ƒ
            return true;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        boolean findNull = false;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.left == null) {
                    findNull = true;
                } else if (findNull) { // leftside already has one null, after that we find one non-null node
                    return false; // there is bubble in the next level, not complete
                } else {
                    q.offer(node.left);
                }
                if (node.right == null) {
                    findNull = true;
                } else if (findNull) {
                    return false;
                } else {
                    q.offer(node.right);
                }
            }
        }
        return true;
    }
}