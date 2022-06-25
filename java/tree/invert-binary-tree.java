class Solution {
    // Method 1: Pre-order Recursion
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }
        // invert current level
        invertLeftRight(root);
        // invert left and right subtree
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    // Method 2: Pre-order Iterative
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // step1: invert current level
            invertLeftRight(cur); // guaranteed TreeNode in the stack is not null
            // step2: add left and right child
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return root;
    }
    // Method 3: BFS Level-order Traversal
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // step1: invert current level
            invertLeftRight(cur); // guaranteed TreeNode in the stack is not null
            // step2: add left and right child
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return root;
    }
    
    private void invertLeftRight(TreeNode root) {
        // assumption: root not null
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}