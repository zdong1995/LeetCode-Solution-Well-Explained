class Solution {
    public void flatten(TreeNode root) {
        if (root == null) { // base case
            return;
        }
        // flatten the left and right subtree
        flatten(root.left);
        flatten(root.right);
        // connect last node of left subtree to first node of right subtree
        connect(root);
    }
    
    /*
        1
       /  \
      2    5
       \    \
        3    6
          \
           4
    */
    private void connect(TreeNode root) {
        TreeNode right = root.right;
        // move the left subtree to be the right subtree of root
        root.right = root.left;
        root.left = null; // delink
        
        TreeNode leftTail = root;
        while (leftTail.right != null) {
            leftTail = leftTail.right;
        }
        // connect the flattened left and right linkedlist
        leftTail.right = right;
    }
}