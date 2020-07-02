class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 1. find the mid node of list
        ListNode mid = findMid(head);
        // 2. reverse the second part
        ListNode reversedMid = reverseList(mid.next);
        mid.next = null; // de-link mid to the second part to avoid potential cycle
        // 3. merge with first part
        ListNode newHead = merge(head, reversedMid);
        head = newHead;
    }
    
    private ListNode findMid(ListNode head) {
        /*
         * return the mid node of linked list (first mid for even number)
         * odd 2n+1 : slow n+1, fast 2n+1
         * even 2n : slow n, fast 2n-1
         * assumption : head != null && head.next != null
         */
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) { // odd case && even case
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        // traverse head1 and head2 to add nodes to tail one by one
        while (head1 != null && head2 != null) {
            tail.next = head1;
            head1 = head1.next;
            tail.next.next = head2;
            head2 = head2.next;
            tail = tail.next.next;
        }
        // out of loop condition:
        // odd: head2 == null but head1 != null -> tail connect to head1
        // even: head1 == null && head2 == null -> no need to do
        if (head1 != null) {
            tail.next = head1;
        }
        return dummy.next; // dummy.next is the real head
    }
}