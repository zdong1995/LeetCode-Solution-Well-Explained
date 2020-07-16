class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; // store head to return
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next; // remove target val node
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}