// DFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, root, 0);
        return res;
    }
    
    // preorder traverse, root -> root.right -> root.left
    private void dfs(List<Integer> list, TreeNode root, int level) {
        // base case
        if (root == null) {
            return;
        }
        if (index == list.size()) {
            // current TreeNode is the first node to reach current level
            // which means it is the first node from right side view
            list.add(root.val);
        }
        dfs(list, root.right, index + 1);
        dfs(list, root.left, index + 1);
    }
}

// BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // level order traverse
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == size - 1) {
                    // add last element of current level to result
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return res;
    }
}