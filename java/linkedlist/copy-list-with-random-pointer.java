class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> copied = new HashMap<>(); // store 1:1 mapping
        Node newHead = new Node(head.val);
        Node cur = newHead;
        copied.put(head, newHead);
        while (head != null) {
            if (head.next != null) { // copy next
                if (!copied.containsKey(head.next)) { // not copied before
                    copied.put(head.next, new Node(head.next.val));
                }
                cur.next = copied.get(head.next);
            }
            if (head.random != null) { // copy random
                if (!copied.containsKey(head.random)) { // not copied before
                    copied.put(head.random, new Node(head.random.val));
                }
                cur.random = copied.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }
}