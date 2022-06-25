class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            // for each iteration, start from dummy (sorted part)
            ListNode prev = dummy;
            // find the last position that smaller than current node
            while (prev.next != null && prev.next.val <= cur.val) {
                prev = prev.next;
            }
            // then insert cur node to prev.next position
            ListNode next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}