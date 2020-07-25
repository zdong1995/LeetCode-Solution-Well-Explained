// recursion
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { // base case
            return head;
        }
        // recursive rule: head -> next -> newHead
        ListNode newHead = swapPairs(head.next.next);
        ListNode next = head.next;
        head.next = newHead;
        next.next = head;
        return next;
    }
}

// iterative
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { // base case
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            // prev -> head -> next -> nnext
            ListNode next = head.next;
            prev.next = next;
            head.next = next.next; // head -> nnext
            next.next = head;
            // prev -> next -> head -> nnext
            // move two steps
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }
}