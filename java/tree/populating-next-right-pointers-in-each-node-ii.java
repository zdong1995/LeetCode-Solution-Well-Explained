class Solution {
    // Method 1: BFS
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
    
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node cur = queue.poll();
                if (size > 0) {
                    // connect cur node to the next in the same level
                    cur.next = queue.peek();
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    // Method 2: Iterative
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMost = root;
        while (leftMost != null) {
            // start from leftMost node to traverse current level
            // and connect the next level
            Node cur = leftMost; // current node at current level
            Node dummy = new Node(0); // used to store head of next level
            Node prev = dummy; // the leading node of next level
            // use dummy to avoid null check to simplify the implementation
            while (cur != null) {
                // traverse current level, to connect prev node to next node in the next level
                if (cur.left != null) {
                    prev.next = cur.left;
                    prev = prev.next;
                }
                if (cur.right != null) {
                    prev.next = cur.right;
                    prev = prev.next;
                }
                // move to next node in current level
                cur = cur.next;
            }
            // move leftMost to left most node of next level, i.e. the head of next level
            leftMost = dummy.next;
        }
        return root;
    }
}