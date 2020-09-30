class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // move fast N steps forward to maintain a window with size N
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // find the (n+1)-th node from end
        // slow stop at the (n+1)-th node, fast stop at last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // delete the N-th node from end
        slow.next = slow.next.next;
        return dummy.next;
    }
}