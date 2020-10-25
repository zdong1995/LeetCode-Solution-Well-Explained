class Solution {
    public Node flatten(Node head) {
        Node cur = head;
        while (cur != null) {
            // case 1: no child, no need to flatten child list
            if (cur.child == null) {
                cur = cur.next;
                continue;
            }
            // case 2: has child, find tail of child list, connect to next
            Node tail = cur.child;
            while (tail.next != null) {
                tail = tail.next;
            }
            // connect with the child list
            tail.next = cur.next;
            if (cur.next != null) { // avoid NPE, cur maybe the last node
                cur.next.prev = tail;
            }
            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null; // delink
            // traverse next node
            cur = cur.next;
        }
        return head;
    }
}