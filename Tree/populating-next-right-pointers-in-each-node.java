class Solution {
    // Method 1: Iterative
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            // start from the leftmost node, connect current level
            Node cur = leftMost;
            while (cur != null) { // traverse the linked list of current level
                // connect for same root nodes
                cur.left.next = cur.right;
                // connect for inter-root nodes
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            leftMost = leftMost.left; // traverse the left most path to arrive last level
        }
        return root;
    }

    // Method 2: Recursion
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        populateTwo(root.left, root.right);
        return root;
    }
    
    // populate next pointers for two adjacent subtree
    // with root as one and two, separately
    private void populateTwo(Node one, Node two) {
        if (one == null || two == null) { // base case
            return;
        }
        // connect current level
        one.next = two;
        // connect left and right subtree for each root
        populateTwo(one.left, one.right);
        populateTwo(two.left, two.right);
        // connect the adjacent two node
        populateTwo(one.right, two.left);
    }
}